/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.service;

import com.spoonjam.myphotos.exception.ObjectNotFoundException;
import com.spoonjam.myphotos.model.AsyncOperation;
import com.spoonjam.myphotos.model.ImageResource;
import com.spoonjam.myphotos.model.domain.Profile;
import java.util.Optional;

/**
 *
 * @author Swap
 */
public interface ProfileService {
    Profile findById(Long id) throws ObjectNotFoundException;
    Profile findByUid(Long id) throws ObjectNotFoundException;
    Optional<Profile> findByEmail(String email);
    void signUp(Profile profile, boolean uploadProfileAvatar);
    void translitSocialProfile(Profile profile);
    void update(Profile profile);
    void uploadNewAvatar(Profile currentProfile, ImageResource imageResource, AsyncOperation<Profile> asyncOperation);
}
