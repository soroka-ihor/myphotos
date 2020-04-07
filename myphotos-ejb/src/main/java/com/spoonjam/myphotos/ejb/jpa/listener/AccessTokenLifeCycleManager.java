/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.ejb.jpa.listener;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import com.spoonjam.myphotos.exception.InvalidWorkFlowException;
import com.spoonjam.myphotos.model.domain.AccessToken;
/**
 *
 * @author Swap
 */
public class AccessTokenLifeCycleManager {
    @Inject
    private Logger logger;

    @PrePersist
    public void setToken(AccessToken model) {
        model.setToken(UUID.randomUUID().toString().replace("-", ""));
        logger.log(Level.FINE, "Generate new uid token {0} for entity {1}", new Object[]{model.getToken(), model.getClass()});
    }
    
    @PreUpdate
    public void rejectUpdate(AccessToken model) {
        throw new InvalidWorkFlowException("AccessToken is not updatedable");
    }
}
