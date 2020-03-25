/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.common.config;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Swap
 */
public final class Constants {
    public static final long MAX_UPLOADED_PHOTO_SIZE_IN_BYTES = 10 * 1024 * 1024; // 10 Mb
    
    public static final long DEFAULT_ASYNC_OPERATION_TIMEOUT_IN_MILLIS = TimeUnit.SECONDS.toMillis(30);

    private Constants(){}
}
