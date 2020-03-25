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
public class ConfigException extends ApplicationException {

    public ConfigException(String string) {
        super(string);
    }

    public ConfigException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
