package com.demo.photographybooking.repository;

import com.demo.photographybooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT c FROM Customer c ORDER BY c.id LIMIT 1000 ")
    List<Customer> fetchAllCustomers();

    @Query("SELECT c FROM Customer c WHERE c.id = :id")
    Customer fetchById(@Param("id") long id);
}
