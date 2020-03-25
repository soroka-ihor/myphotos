/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.ejb.repository.mock;

import static com.spoonjam.myphotos.ejb.repository.mock.InMemoryDataBase.PROFILE;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Swap
 */
@ApplicationScoped
public class ProfileRepositoryInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("findByUid".equals(method.getName())) {
            String uid = String.valueOf(args[0]);
            if("richard-hendricks".equals(uid)) {
                return Optional.of(PROFILE);
            } else {
                return Optional.empty();
            }
        }
        throw new UnsupportedOperationException(String.format("Method %s not implemented yet", method));
    }
}

