package com.demo.photographybooking.service.impl;

import com.demo.photographybooking.entity.Customer;
import com.demo.photographybooking.repository.CustomerRepository;
import com.demo.photographybooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    private static final int PASSWORD_LENGTH = 8;

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
    public Customer fetchById(Long id) {
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

    @Override
    public ResponseEntity<String> registerCustomer(String name, String email, String password) {

        try {
            if (name.isEmpty() || email.isEmpty() || password.length() < PASSWORD_LENGTH) {
                return ResponseEntity.badRequest().body("Fields cant be empty and password length must more than 8 character");
            } else {
                Customer existingCustomer = customerRepository.findByEmail(email);
                if (existingCustomer != null) {
                    return ResponseEntity.badRequest().body("Account is already exist");
                }

                Customer newCustomer = new Customer(name, email, password);
                customerRepository.save(newCustomer);

                // Registration successful
                return ResponseEntity.ok("Customer registered successfully.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Please provide all required information.");
        }
    }

}
