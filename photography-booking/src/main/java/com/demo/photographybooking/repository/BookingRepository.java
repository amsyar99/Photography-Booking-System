package com.demo.photographybooking.repository;

import com.demo.photographybooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT b FROM Booking b ORDER BY b.id LIMIT 1000")
    List<Booking> fetchAllBooking();
}
