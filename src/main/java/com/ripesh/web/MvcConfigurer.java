/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ripesh.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author USER
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "com.ripesh.web")
@PropertySource(value = "classpath:application.properties")
public class MvcConfigurer {
    
    @Value(value = "${mvc.view.prefix}")
    private String viewPrefix;
    @Value(value = "${mvc.view.suffix}")
    private String viewSufffix;
    
    
    @Bean
    public InternalResourceViewResolver getViewResolver(){
        return new InternalResourceViewResolver(viewPrefix, viewSufffix);
    }
}
