/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.ejb.repository.jpa;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.spoonjam.ejb.myphotos.repository.EntityRepository;
/**
 *
 * @author Swap
 */
abstract class AbstractJPARepository<T, ID> implements EntityRepository<T, ID>{

    @PersistenceContext(unitName = "com.spoonjam.myphotos.pu")
    protected EntityManager em;
    
    protected abstract Class<T> getEntityClass();
    
    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(em.find(getEntityClass(), id));
    }

    @Override
    public void create(T entity) {
        em.persist(entity);
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public void flush() {
        em.flush();
    }

    @Override
    public T getProxyInstance(ID id) {
        return em.getReference(getEntityClass(), id);
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
