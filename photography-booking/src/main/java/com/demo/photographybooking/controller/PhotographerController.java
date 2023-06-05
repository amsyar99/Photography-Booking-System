package com.demo.photographybooking.controller;

import com.demo.photographybooking.entity.Customer;
import com.demo.photographybooking.entity.Photographer;
import com.demo.photographybooking.service.CustomerService;
import com.demo.photographybooking.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/getCustomersById")
    public Customer getCustomersById(@RequestBody Map<String, String> requestParams) {
        String id = requestParams.get("id");
        return customerService.fetchById(id);
    }

    @GetMapping("/getPhotographers")
    public List<Photographer> getAllPhotographers() {
        return photographerService.fetchAllPhotographers();
    }

    @PostMapping("/getPhotographersById")
    public Photographer getPhotographersById(@RequestBody Map<String, String> requestParams) {
        String id = requestParams.get("id");
        return photographerService.fetchById(id);
    }

    @GetMapping("/getPhotographersById")
    public List<Photographer> getPhotographersByName(@RequestParam(name = "name") String name) {
        return photographerService.fetchByName(name);
    }

    @GetMapping("/getPhotographersByEmail")
    public Photographer getPhotographersByEmail(@RequestParam(name = "email") String email) {
        return photographerService.fetchByEmail(email);
    }
}
