/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.exception;

/**
 *
 * @author Swap
 */
public abstract class BusinessException extends ApplicationException {

    public BusinessException(String string) {
        super(string, null, true, false);
    }
    
}
