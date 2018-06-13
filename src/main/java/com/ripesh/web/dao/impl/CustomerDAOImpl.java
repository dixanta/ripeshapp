/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ripesh.web.dao.impl;

import com.ripesh.web.dao.CustomerDAO;
import com.ripesh.web.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    private void getSession(){
        session=sessionFactory.openSession();
    }
    public void save(Customer model) {
        getSession();
        transaction=session.beginTransaction();
        session.saveOrUpdate(model);
        transaction.commit();
    }
    
}
