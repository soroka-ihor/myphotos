/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.ejb.repository.mock;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import static com.spoonjam.myphotos.ejb.repository.mock.InMemoryDataBase.PHOTOS;
import static com.spoonjam.myphotos.ejb.repository.mock.InMemoryDataBase.PROFILE;
/**
 *
 * @author Swap
 */
@ApplicationScoped
public class PhotoRepositoryInvocationHandler implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        switch (method.getName()) {
            case "findProfilePhotosLatestFirst":
                return findProfilePhotosLatestFirst(args);
            case "findAllOrderByViewsDesc":
            case "findAllOrderByAuthorRatingDesc":
                return findAll(args);
            case "countAll":
                return countAll(args);
            default:
                throw new UnsupportedOperationException(String.format("Method %s not implemented yet", method));
        }
    }

    private Object findProfilePhotosLatestFirst(Object[] args) {
        Long profileId = (Long) args[0];
        int offset = (Integer) args[1];
        int limit = (Integer) args[2];
        if(profileId.equals(PROFILE.getId())) {
            return PHOTOS.stream().skip(offset).limit(limit).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    private Object findAll(Object[] args) {
        int offset = (Integer) args[0];
        int limit = (Integer) args[1];
        return PHOTOS.stream().skip(offset).limit(limit).collect(Collectors.toList());
    }

    private Object countAll(Object[] args) {
        return (long)PHOTOS.size();
    }
}
