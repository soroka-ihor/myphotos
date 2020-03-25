/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.common.resource;

import com.spoonjam.myphotos.exception.ConfigException;
import java.io.IOException;
import java.io.InputStream;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Swap
 */
@ApplicationScoped
public class ClassPathResourceLoader implements ResourceLoader {

    @Override
    public boolean isSupport(String resourceName) {
        return resourceName.startsWith("classpath");
    }

    @Override
    public InputStream getInputStream(String resourceName) {
        String classPathResourceName = resourceName.replace("classpath:", "");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null) {
            InputStream inputStream = classLoader.getResourceAsStream(classPathResourceName);
            if (inputStream != null) {
                return inputStream;
            }
        }
        throw new ConfigException("Classpath resource not found: " + classPathResourceName);
    }
    
}
