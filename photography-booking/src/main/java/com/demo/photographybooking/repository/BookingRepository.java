package com.demo.photographybooking.repository;

import com.demo.photographybooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT b FROM Booking b ORDER BY b.id LIMIT 1000")
    List<Booking> fetchAllBooking();

    @Query(value = "SELECT * FROM Booking b WHERE b.id = :id")
    Booking fetchById(@Param("id") String id);

    @Query(value = "SELECT * FROM Booking b WHERE b.bookingDate BETWEEN :startDate AND :endDate")
    List<Booking> fetchByDate(@Param("startDate") LocalDate startDate, @Param("endDate")LocalDate endDate);

    @Query(value = "SELECT * FROM Booking b WHERE b.customerId = :custId")
    List<Booking> fetchByCustomerId(@Param("custId") String custId);

    @Query(value = "SELECT * FROM Booking WHERE b.photographerId = :photoId")
    List<Booking> fetchByPhotographerId(@Param("photoId") String photoId);
}
