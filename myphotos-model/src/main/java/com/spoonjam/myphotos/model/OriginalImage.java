/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.model;

import java.io.InputStream;
import java.util.Objects;

/**
 *
 * @author Swap
 */
public class OriginalImage {
    private final InputStream in;
    private final long size;
    private final String name;
    
    public OriginalImage(InputStream in, long size, String name) {
        this.in = Objects.requireNonNull(in);
        this.size = size;
        this.name = Objects.requireNonNull(name);
    }

    public InputStream getIn() {
        return in;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
    
}
