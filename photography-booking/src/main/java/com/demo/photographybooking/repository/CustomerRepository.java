package com.demo.photographybooking.repository;

import com.demo.photographybooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM CUSTOMERS LIMIT 1000 ORDER BY ID")
    List<Customer> fetchAllCustomers();

    @Query(value = "SELECT * FROM CUSTOMER WHERE ID = ")
    Customer fetchById(String id);
}
