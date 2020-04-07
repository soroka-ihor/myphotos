/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.ejb.repository.jpa;

import java.util.Optional;
import javax.enterprise.context.Dependent;
import com.spoonjam.ejb.myphotos.repository.AccessTokenRepository;
import com.spoonjam.myphotos.model.domain.AccessToken;
/**
 *
 * @author Swap
 */
@Dependent
public class AccessTokenRepositoryImpl extends AbstractJPARepository<AccessToken, String> implements AccessTokenRepository{

    @Override
    protected Class<AccessToken> getEntityClass() {
        return AccessToken.class;
    }

    @Override
    public Optional<AccessToken> findByToken(String token) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean removeAccessToken(String token) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
