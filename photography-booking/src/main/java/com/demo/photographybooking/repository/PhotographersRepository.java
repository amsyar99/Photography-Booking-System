package com.demo.photographybooking.repository;

import com.demo.photographybooking.entity.Photographers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotographersRepository extends JpaRepository {

    @Query(value = "SELECT * FROM PHOTOGRAPHERS LIMIT 1000 ORDER BY ID")
    List<Photographers> fetchAll();

    @Query(value = "SELECT * FROM PHOTOGRAPHERS WHERE ID = :id")
    Photographers fetchById(@Param("id") String id);
}
