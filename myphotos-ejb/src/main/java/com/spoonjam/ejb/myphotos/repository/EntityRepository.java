/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.ejb.myphotos.repository;

import java.util.Optional;

/**
 *
 * @author Swap
 */
public interface EntityRepository<T, ID> {
    Optional<T> findById(ID id);
    
    void create(T entity);
    
    void update(T entity);
    
    void delete(T entity);
    
    void flush();
    
    T getProxyInstance(ID id);
}
