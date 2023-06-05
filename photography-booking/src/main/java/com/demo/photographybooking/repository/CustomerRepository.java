package com.demo.photographybooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository {

    @Query(value = "SELECT * FROM CUSTOMERS LIMIT 1000 ORDER BY ID", nativeQuery = true)
    List<String> fetchAllCustomers();
}
