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
public class RetrieveSocialDataFailedException extends ApplicationException{

    public RetrieveSocialDataFailedException(String string) {
        super(string);
    }

    public RetrieveSocialDataFailedException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

   
    
}
