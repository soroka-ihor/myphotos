/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.web.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.spoonjam.myphotos.model.Pageable;
import com.spoonjam.myphotos.model.SortMode;
import com.spoonjam.myphotos.model.domain.Photo;
import com.spoonjam.myphotos.model.domain.Profile;
import com.spoonjam.myphotos.service.PhotoService;
import com.spoonjam.myphotos.service.ProfileService;
import static com.spoonjam.myphotos.web.Constants.PHOTO_LIMIT;
import static com.spoonjam.myphotos.web.util.RoutingUtils.forwardToPage;

/**
 *
 * @author Swap
 */
@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class ProfileController extends HttpServlet{

    private final List<String> homeUrls;

    @EJB
    private ProfileService profileService;

    @EJB
    private PhotoService photoService;

    public ProfileController() {
        this.homeUrls = Collections.unmodifiableList(Arrays.asList("/"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (isHomeUrl(url)) {
            handleHomeRequest(req, resp);
        } else {
            handleProfileRequest(req, resp);
        }
    }

    private boolean isHomeUrl(String url) {
        return homeUrls.contains(url);
    }

    private void handleHomeRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SortMode sortMode = getSortMode(req);
        List<Photo> photos = photoService.findPopularPhotos(sortMode, new Pageable(1, PHOTO_LIMIT));
        req.setAttribute("photos", photos);
        long totalCount = photoService.countAllPhotos();
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("sortMode", sortMode.name().toLowerCase());
        forwardToPage("home", req, resp);
    }

    private SortMode getSortMode(HttpServletRequest req) {
        Optional<String> sortMode = Optional.ofNullable(req.getParameter("sort"));
        return sortMode.isPresent() ? SortMode.of(sortMode.get()) : SortMode.POPULAR_PHOTO;
    }

    private void handleProfileRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String uid = req.getRequestURI().substring(1);
        Profile profile = profileService.findByUid(uid);
        req.setAttribute("profile", profile);
        req.setAttribute("profilePhotos", Boolean.TRUE);
        List<Photo> photos = photoService.findProfilePhotos(profile.getId(), new Pageable(1, PHOTO_LIMIT));
        req.setAttribute("photos", photos);
        forwardToPage("profile", req, resp);
    }
}
