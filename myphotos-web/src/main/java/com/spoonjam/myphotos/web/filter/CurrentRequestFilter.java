/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.web.filter;

/**
 *
 * @author Swap
 */
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "CurrentRequestFilter", asyncSupported = true)
public class CurrentRequestFilter extends AbstractFilter{
    
    public static final String CURRENT_REQUEST_URL = "currentRequestUrl";

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute(CURRENT_REQUEST_URL, request.getRequestURI());
        chain.doFilter(request, response);
    }
}