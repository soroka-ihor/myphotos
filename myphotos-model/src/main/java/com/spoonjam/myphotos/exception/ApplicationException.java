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
public class ApplicationException extends RuntimeException {

    public ApplicationException(String string) {
        super(string);
    }

    public ApplicationException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ApplicationException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ApplicationException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
