/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.model;

import com.spoonjam.myphotos.exception.ValidationException;

/**
 *
 * @author Swap
 */
public enum SortMode {
    POPULAR_PHOTO, 
    POPULAR_AUTHOR;
    
    public static SortMode of(String name) {
        for (SortMode sortMode : SortMode.values()) {
            if (sortMode.name().equalsIgnoreCase(name)) {
                return sortMode;
            }
        }
        throw new ValidationException("Undefined sort mode: " + String.valueOf(name.toUpperCase()));
    }
}
