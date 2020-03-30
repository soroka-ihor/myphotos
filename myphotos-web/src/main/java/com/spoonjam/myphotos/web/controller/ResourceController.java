/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.web.controller;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Swap
 */
@WebServlet(urlPatterns = {"/static/*", "/favicon.ico"}, loadOnStartup = 1)
public class ResourceController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Paths.get(getServletContext().getRealPath("/")+req.getRequestURI());
        resp.setContentType(getServletContext().getMimeType(path.toString()));
        resp.setContentLengthLong(Files.size(path));
        try(OutputStream out = resp.getOutputStream()) {
            Files.copy(path, out);
        }
    }
}
