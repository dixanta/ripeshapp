/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ripesh.web;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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
    private String viewSuffix;
    
    @Value(value = "${jdbc.driverClassName}")
    private String jdbcDriver;
    
    @Value(value = "${jdbc.url}")
    private String jdbcURL;
    
    @Value(value = "${jdbc.username}")
    private String jdbcUser;
    
    @Value(value = "${jdbc.password}")
    private String jdbcPassword;
    
    @Value(value = "${hibernate.dialect}")
    private String hibernateDialect;
    
    @Value(value = "${hibernate.show_sql}")
    private String hibernateShowSql;
    
    @Bean
    public InternalResourceViewResolver getViewResolver(){
        return new InternalResourceViewResolver(viewPrefix, viewSuffix);
    }
    
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource ds=
                new DriverManagerDataSource(jdbcURL, 
                        jdbcUser, jdbcPassword);
        ds.setDriverClassName(jdbcDriver);
        return ds;
    }
    
    private Properties getHibernateProperties(){
        Properties properties=new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql",hibernateShowSql);
        return properties;
    }
    @Bean 
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean sessionBean=
                new LocalSessionFactoryBean();
        sessionBean.setDataSource(getDataSource());
        sessionBean.setPackagesToScan("com.ripesh.web.entity");
        sessionBean.setHibernateProperties(getHibernateProperties());
        return sessionBean;
        
    }
}
