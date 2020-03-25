/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.model.validation;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Swap
 */
@Pattern (regexp = "^(.+)@(.+)$")
@Constraint(validatedBy = {})
@Target ({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default ("javax.validation.constraints.Email.message");
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{} ;
}
