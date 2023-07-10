package com.demo.photographybooking.controller;

import com.demo.photographybooking.entity.Customer;
import com.demo.photographybooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/getCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.fetchAllCustomers();
    }

    @PostMapping("/getCustomersById")
    public Customer getCustomersById(@RequestBody Map<String, String> requestParams) {
        long id = Long.parseLong(requestParams.get("id"));
        return customerService.fetchById(id);
    }

    @PostMapping("/registerCustomer")
    public ResponseEntity<String> registerCustomer(@RequestBody Map<String, String> requestParams) {

            String name = requestParams.get("name");
            String email = requestParams.get("email");
            String password = requestParams.get("password");

            return customerService.registerCustomer(name, email, password);
    }

}
