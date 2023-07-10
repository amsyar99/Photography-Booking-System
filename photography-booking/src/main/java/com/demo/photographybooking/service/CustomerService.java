package com.demo.photographybooking.service;

import com.demo.photographybooking.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    List<Customer> fetchAllCustomers();

    Customer fetchById(Long id);

    ResponseEntity<String> registerCustomer(String name, String email, String password);


}
