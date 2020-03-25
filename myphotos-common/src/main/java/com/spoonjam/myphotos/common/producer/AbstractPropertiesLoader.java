/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.common.producer;
import com.spoonjam.myphotos.common.resource.ResourceLoaderManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Swap
 */
public abstract class AbstractPropertiesLoader {
     @Inject
    protected Logger logger;

    @Inject
    protected ResourceLoaderManager resourceLoaderManager;

    protected void loadProperties(Properties properties, String resourceName) {
        try {
            try (InputStream in = resourceLoaderManager.getResourceInputStream(resourceName)) {
                properties.load(in);
            }
            logger.log(Level.INFO, "Successful loaded properties from {0}", resourceName);
        } catch (IOException | RuntimeException ex) {
            logger.log(Level.WARNING, "Can't load properties from: " + resourceName, ex);
        }
    }
}
