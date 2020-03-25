/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.ejb.repository.mock;

import com.spoonjam.ejb.myphotos.repository.PhotoRepository;
import com.spoonjam.ejb.myphotos.repository.ProfileRepository;
import java.lang.reflect.Proxy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author Swap
 */
@ApplicationScoped
public class InMemoryRepositoryFactory {
    @Inject
    private ProfileRepositoryInvocationHandler profileRepositoryInvocationHandler;
    
    @Inject
    private PhotoRepositoryInvocationHandler photoRepositoryInvocationHandler;

    @Produces
    public ProfileRepository getProfileRepository(){
        return (ProfileRepository) Proxy.newProxyInstance(getClass().getClassLoader(), 
                new Class[]{ProfileRepository.class}, profileRepositoryInvocationHandler);
    }
    
    @Produces
    public PhotoRepository getPhotoRepository(){
        return (PhotoRepository) Proxy.newProxyInstance(getClass().getClassLoader(), 
                new Class[]{PhotoRepository.class}, photoRepositoryInvocationHandler);
    }
}
