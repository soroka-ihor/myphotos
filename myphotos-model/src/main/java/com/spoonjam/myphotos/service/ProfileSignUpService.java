/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.service;

import com.spoonjam.myphotos.exception.ObjectNotFoundException;
import com.spoonjam.myphotos.model.domain.Profile;

/**
 *
 * @author Swap
 */
public interface ProfileSignUpService {
    void createSignUpProfile(Profile profile);
    Profile getCurrentProfile() throws ObjectNotFoundException;
    void completeSignUp();
    void cancel();
}
