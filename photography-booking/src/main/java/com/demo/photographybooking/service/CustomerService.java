package com.demo.photographybooking.service;

import com.demo.photographybooking.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> fetchAllCustomers();
}
