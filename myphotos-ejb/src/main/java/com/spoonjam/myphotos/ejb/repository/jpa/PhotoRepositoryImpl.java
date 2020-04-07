/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.ejb.repository.jpa;

import java.util.List;
import javax.enterprise.context.Dependent;
import com.spoonjam.ejb.myphotos.repository.PhotoRepository;
import com.spoonjam.myphotos.model.domain.Photo;

/**
 *
 * @author Swap
 */
@Dependent
public class PhotoRepositoryImpl extends AbstractJPARepository<Photo, Long> implements PhotoRepository {

    @Override
    protected Class<Photo> getEntityClass() {
        return Photo.class;
    }

    @Override
    public List<Photo> findProfilePhotosLatestFirst(Long profileId, int offset, int limit) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public int countProfilePhotos(Long profileId) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public List<Photo> findAllOrderByViewsDesc(int offset, int limit) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public List<Photo> findAllOrderByAuthorRatingDesc(int offset, int limit) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public long countAll() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
