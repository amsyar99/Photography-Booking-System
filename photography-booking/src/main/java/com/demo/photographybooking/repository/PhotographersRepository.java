package com.demo.photographybooking.repository;

import com.demo.photographybooking.entity.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotographersRepository extends JpaRepository<Photographer, Long> {

    @Query(value = "SELECT p FROM Photographer p  ORDER BY p.id LIMIT 1000")
    List<Photographer> fetchAllPhotographers();

    @Query("SELECT p FROM Photographer p WHERE p.id = :id")
    Photographer fetchById(@Param("id") String id);
}
