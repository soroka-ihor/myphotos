/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.model.validation;

import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;


/**
 *
 * @author Swap
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = {EnglishLanguageConstraintValidator.class})
public @interface EnglishLanguage {
    String message() default "{javax.validation.constraints.EnglishLanguage.message}";
    
    //0123456789
    boolean withNumbers() default true;
    
    //.,?!-:()'"; \t \n
    boolean withPunctuations() default true;
    
    //#$@&^^%)(+-=%[]{}
    boolean withSpecialSymbols() default true;
    
}
