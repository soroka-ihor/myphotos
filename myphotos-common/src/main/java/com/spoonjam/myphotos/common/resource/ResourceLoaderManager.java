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
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author Swap
 */
@ApplicationScoped
public class ResourceLoaderManager {
    @Inject
    @Any
    private Instance<ResourceLoader> resourceLoaders;

    public InputStream getResourceInputStream(String resourceName) throws IOException {
        for (ResourceLoader resourceLoader : resourceLoaders) {
            if (resourceLoader.isSupport(resourceName)) {
                return resourceLoader.getInputStream(resourceName);
            }
        }

        throw new ConfigException("Can't get input stream for resource: " + resourceName);
    }
}
