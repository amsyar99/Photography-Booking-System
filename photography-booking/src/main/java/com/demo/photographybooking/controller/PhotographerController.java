package com.demo.photographybooking.controller;

import com.demo.photographybooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotographerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/getCustomers")
    public List<String> getAllCustumers() {
        return customerService.
    }
}
