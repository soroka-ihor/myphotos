/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.model;

/**
 *
 * @author Swap
 */
public interface AsyncOperation<T> {
    long getTimeOutInMillis();
    void onSuccess(T result);
    void onFailed(Throwable throwable);
}
