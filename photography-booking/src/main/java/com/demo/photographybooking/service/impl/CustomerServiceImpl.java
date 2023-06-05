package com.demo.photographybooking.service.impl;

import com.demo.photographybooking.entity.Customer;
import com.demo.photographybooking.repository.CustomerRepository;
import com.demo.photographybooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> fetchAllCustomers() {

        List<Customer> response = new ArrayList<>();

        try {
            List<Customer> listCustomers = customerRepository.fetchAllCustomers();

            if (!listCustomers.isEmpty())
                response.addAll(listCustomers);

        } catch (Exception e) {
            System.out.println("Error get all customers: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Customer fetchById(String id) {
        Customer response = new Customer();

        try {
            Customer customer = customerRepository.fetchById(id);

            if (Objects.nonNull(customer)) {
                response = customer;
            }

        } catch (Exception e) {
            System.out.println("Error get customer: " + id);
        }

        return response;
    }
}
