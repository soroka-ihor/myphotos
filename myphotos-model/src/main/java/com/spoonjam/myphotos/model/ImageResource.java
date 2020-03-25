/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.model;

import javax.validation.Path;

/**
 *
 * @author Swap
 */
public interface ImageResource extends AutoCloseable {

    Path getTempPath();
    
    @Override
    void close();
    
}
