/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.ejb.repository.jpa;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.Dependent;
import com.spoonjam.ejb.myphotos.repository.ProfileRepository;
import com.spoonjam.myphotos.model.domain.Profile;

/**
 *
 * @author Swap
 */
@Dependent
public class ProfileRepositoryImpl extends AbstractJPARepository<Profile, Long> implements ProfileRepository{

    @Override
    protected Class<Profile> getEntityClass() {
        return Profile.class;
    }

    @Override
    public Optional<Profile> findByUid(String uid) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Optional<Profile> findByEmail(String email) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void updateRating() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public List<String> findUids(List<String> uids) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
