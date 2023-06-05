package com.demo.photographybooking.service.impl;

import com.demo.photographybooking.entity.Customer;
import com.demo.photographybooking.repository.CustomerRepository;
import com.demo.photographybooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customer;

    @Override
    public List<Customer> fetchAllCustomers() {

        List<Customer> response = new ArrayList<>();

        try {
            List<Customer> listCustomers = customer.fetchAllCustomers();

            if (!listCustomers.isEmpty())
                response.addAll(listCustomers);

        } catch (Exception e) {
            System.out.println("Error get all customers: " + e.getMessage());
        }

        return response;
    }
}
