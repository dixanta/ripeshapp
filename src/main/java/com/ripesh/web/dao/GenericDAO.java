/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ripesh.web.dao;

import java.util.List;

/**
 *
 * @author USER
 */
public interface GenericDAO<T> {
    void save(T model);
    List<T> getAll();
    T getById(int id);
    boolean delete(int id);
}
