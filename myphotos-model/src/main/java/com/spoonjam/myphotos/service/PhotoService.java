/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.service;

import com.spoonjam.myphotos.exception.ObjectNotFoundException;
import com.spoonjam.myphotos.model.AsyncOperation;
import com.spoonjam.myphotos.model.ImageResource;
import com.spoonjam.myphotos.model.OriginalImage;
import com.spoonjam.myphotos.model.Pageable;
import com.spoonjam.myphotos.model.SortMode;
import com.spoonjam.myphotos.model.domain.Photo;
import com.spoonjam.myphotos.model.domain.Profile;
import java.util.List;

/**
 *
 * @author Swap
 */
public interface PhotoService {
    List<Photo> findProfilePhotos(Long profileId, Pageable pageable);
    List<Photo> findPopularPhotos(SortMode sortMode, Pageable pageable);
    long countAllPhotos();
    String viewLargePhoto(Long photoId) throws ObjectNotFoundException;
    OriginalImage downloadOriginalImage(Long photoId) throws ObjectNotFoundException;
    void uploadNewPhoto(Profile currentProfile, ImageResource imageResource, AsyncOperation<Photo> asyncOperation);
}
