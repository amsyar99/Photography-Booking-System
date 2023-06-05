package com.demo.photographybooking.controller;

import com.demo.photographybooking.entity.Customer;
import com.demo.photographybooking.entity.Photographers;
import com.demo.photographybooking.service.CustomerService;
import com.demo.photographybooking.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotographerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    PhotographerService photographerService;

    @GetMapping("/getCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.fetchAllCustomers();
    }

    @GetMapping("/getPhotographers")
    public List<Photographers> getAllPhotographers() {
        return photographerService.fetchAllPhotographers();
    }

    @GetMapping("/getPhotographersById")
    public Photographers getPhotographersById(@RequestParam(name = "id") String id) {
        return photographerService.fetchById(id);
    }
}
