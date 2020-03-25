/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.ejb.myphotos.repository;

import com.spoonjam.myphotos.model.domain.Profile;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Swap
 */
public interface ProfileRepository extends EntityRepository<Profile, Long> {
    Optional<Profile> findByUid(String uid);
    
    Optional<Profile> findByEmail(String email);
    
    void updateRating();
    
    List<String> findUids(List<String> uids);
}
