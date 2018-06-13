/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ripesh.web.controller.admin;


import com.ripesh.web.dao.CustomerDAO;
import com.ripesh.web.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping(value = "/admin/customers")
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;
    @GetMapping()
    public String index(Model model){
        model.addAttribute("customers", customerDAO.getAll());
        return "admin/customers/index";
    }
}
