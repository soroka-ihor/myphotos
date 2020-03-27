/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.ejb.service.bean;
import com.spoonjam.ejb.myphotos.repository.AccessTokenRepository;
import com.spoonjam.myphotos.exception.AccessForbiddenException;
import com.spoonjam.myphotos.exception.InvalidAccessTokenException;
import com.spoonjam.myphotos.model.domain.AccessToken;
import com.spoonjam.myphotos.model.domain.Profile;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.spoonjam.myphotos.service.*;

/**
 *
 * @author Swap
 */
@Stateless
@Local(AccessTokenService.class)
public class AccessTokenServiceBean implements AccessTokenService {

    @Inject
    private Logger logger;
    
    @Inject
    private AccessTokenRepository accessTokenRepository;

    @Override
    public AccessToken generateAccessToken(Profile profile) {
        AccessToken accessToken = new AccessToken();
        accessToken.setProfileId(profile);
        accessTokenRepository.create(accessToken);
        return accessToken;
    }

    @Override
    public Profile findProfile(String token, Long profileId){
        Optional<AccessToken> accessTokenOptional = accessTokenRepository.findByToken(token);
        if(!accessTokenOptional.isPresent()) {
            throw new InvalidAccessTokenException(String.format("Access token %s invalid", token));
        }
        Profile profile = accessTokenOptional.get().getProfileId();
        if(!profile.getId().equals(profileId)) {
            throw new AccessForbiddenException(String.format("Access forbidden for token=%s and profileId=%s", token, profileId));
        }
        return profile;
    }

    @Override
    public void invalidateAccessToken(String token) {
        boolean removed = accessTokenRepository.removeAccessToken(token);
        if(!removed) {
            logger.log(Level.WARNING, "Access token {0} not found", token);
            throw new InvalidAccessTokenException("Access token not found");
        }
    }

}
