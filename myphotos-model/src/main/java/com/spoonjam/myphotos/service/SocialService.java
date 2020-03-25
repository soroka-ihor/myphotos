/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.service;

import com.spoonjam.myphotos.exception.RetrieveSocialDataFailedException;
import com.spoonjam.myphotos.model.domain.Profile;

/**
 *
 * @author Swap
 */
public interface SocialService {
    Profile fetchProfile(String code) throws RetrieveSocialDataFailedException;
    String getClientId();
    default String getAuthorizeUrl() {
        throw new UnsupportedOperationException();
    }
}
