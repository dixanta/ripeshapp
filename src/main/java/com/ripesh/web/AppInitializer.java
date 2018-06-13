/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ripesh.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author USER
 */
public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext ctx
                =new AnnotationConfigWebApplicationContext();
        ctx.register(MvcConfigurer.class);
        ServletRegistration.Dynamic dispatcher=
                sc.addServlet("dispatcher",
                        new DispatcherServlet(ctx));
        dispatcher.addMapping("/home");
        dispatcher.setLoadOnStartup(1);
    }
    
}
