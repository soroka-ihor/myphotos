/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.common.producer;
import java.util.Properties;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import com.spoonjam.myphotos.common.annotation.cdi.PropertiesSource;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Swap
 */
@Dependent
public class PropertiesSourceProducer extends AbstractPropertiesLoader {

    @Produces
    @PropertiesSource("")
    private Properties loadProperties(InjectionPoint injectionPoint) {
        Properties properties = new Properties();
        PropertiesSource propertiesSource = injectionPoint.getAnnotated().getAnnotation(PropertiesSource.class);
        loadProperties(properties, propertiesSource.value());
        return properties;
    }
}
