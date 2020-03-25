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
public class InvalidAccessTokenException extends BusinessException{

    public InvalidAccessTokenException(String string) {
        super(string);
    }
    
}
