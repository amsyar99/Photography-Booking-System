package com.demo.photographybooking.service;

import com.demo.photographybooking.entity.Customer;
import com.demo.photographybooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customer;

    @Override
    public List<String> fetchAllCustomers() {

        List<String> response = new ArrayList<>();

        try {
            List<String> listCustomers = customer.fetchAllCustomers();

            if (!listCustomers.isEmpty())
                response.addAll(listCustomers);
            else
                response.add("No customers at the moments.");

        } catch (Exception e) {
            System.out.println("Error get all customers: " + e.getMessage());
        }

        return response;
    }
}
