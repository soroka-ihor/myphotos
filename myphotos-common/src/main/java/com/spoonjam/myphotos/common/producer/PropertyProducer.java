/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.common.producer;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import com.spoonjam.myphotos.common.annotation.cdi.Property;
import com.spoonjam.myphotos.exception.ConfigException;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Swap
 */
@Dependent
public class PropertyProducer {

    @Inject
    private ApplicationPropertiesStorage applicationPropertiesStorage;

    @Produces
    @Property
    public String resolveStringPropertyValue(InjectionPoint injectionPoint) {
        return resolvePropertyValue(injectionPoint);
    }
    
    @Produces
    @Property
    public int resolveIntPropertyValue(InjectionPoint injectionPoint) {
        return Integer.parseInt(resolvePropertyValue(injectionPoint));
    }
    
    @Produces
    @Property
    public boolean resolveBooleanPropertyValue(InjectionPoint injectionPoint) {
        return Boolean.parseBoolean(resolvePropertyValue(injectionPoint));
    }
    
    private String resolvePropertyValue(InjectionPoint injectionPoint) {
        String className = injectionPoint.getMember().getDeclaringClass().getName();
        String memberName = injectionPoint.getMember().getName();
        Property property = injectionPoint.getAnnotated().getAnnotation(Property.class);
        return resolvePropertyValue(className, memberName, property);
    }

    private String resolvePropertyValue(String className, String memberName, Property property) {
        String propertyName = getPropertyName(className, memberName, property);
        String propertyValue = applicationPropertiesStorage.getApplicationProperties().getProperty(propertyName);
        if(propertyValue == null) {
            throw new ConfigException(String.format("Can't resolve property: '%s' for injection to %s.%s", propertyName, className, memberName));
        } else {
            return propertyValue;
        }
    }

    private String getPropertyName(String className, String memberName, Property property) {
        String value = property.value();
        if("".equals(value)) {
            return String.format("%s.%s", className, memberName);
        } else {
            return value;
        }
    }
}
