/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.common.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Swap
 */
public interface ResourceLoader {
    boolean isSupport(String resourceName);
    InputStream getInputStream(String resourceName) throws IOException;
}
