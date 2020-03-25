/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.ejb.myphotos.repository;

import com.spoonjam.myphotos.model.domain.Photo;
import java.util.List;

/**
 *
 * @author Swap
 */
public interface PhotoRepository extends EntityRepository<Photo, Long>{
    List<Photo> findProfilePhotosLatestFirst(Long profileId, int offset, int limit);
    
    int countProfilePhotos(Long profileId);
    
    List<Photo> findAllOrderByViewsDesc(int offset, int limit);
    
    List<Photo> findAllOrderByAuthorRatingDesc(int offset, int limit);
    
    long countAll();
}
