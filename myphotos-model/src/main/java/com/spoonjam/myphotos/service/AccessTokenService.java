/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.service;

import com.spoonjam.myphotos.exception.AccessForbiddenException;
import com.spoonjam.myphotos.exception.InvalidAccessTokenException;
import com.spoonjam.myphotos.model.domain.AccessToken;
import com.spoonjam.myphotos.model.domain.Profile;

/**
 *
 * @author Swap
 */
public interface AccessTokenService {
    AccessToken generateAccessToken(Profile profile);
    Profile findProfile(String token, Long profileId) throws AccessForbiddenException, InvalidAccessTokenException;
    void invalidateAccessToken(String token) throws InvalidAccessTokenException;
}
