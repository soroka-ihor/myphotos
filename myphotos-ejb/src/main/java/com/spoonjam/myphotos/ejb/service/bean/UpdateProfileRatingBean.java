/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.ejb.service.bean;
import com.spoonjam.ejb.myphotos.repository.ProfileRepository;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Swap
 */
@Stateless
public class UpdateProfileRatingBean {
    
    @Inject
    private Logger logger;

    @Inject
    private ProfileRepository profileRepository;
    
    @Schedule(hour = "0", minute = "0", second = "0", persistent = false)
    public void updateProfileRating(){
        profileRepository.updateRating();
        logger.info("Successful updated profile rating");
    }
}
