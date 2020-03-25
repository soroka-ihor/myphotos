/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.ejb.myphotos.repository;

import com.spoonjam.myphotos.model.domain.AccessToken;
import java.util.Optional;

/**
 *
 * @author Swap
 */
public interface AccessTokenRepository extends EntityRepository<AccessToken, String>{
    Optional<AccessToken> findByToken(String token);
    
    boolean removeAccessToken(String token);
}
