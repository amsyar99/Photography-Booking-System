package com.demo.photographybooking.repository;

import com.demo.photographybooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT b FROM Booking b ORDER BY b.id LIMIT 1000")
    List<Booking> fetchAllBooking();

    @Query(value = "SELECT b FROM Booking b WHERE b.id = ?1")
    Booking fetchById(String id);

    @Query(value = "SELECT b FROM Booking b WHERE b.bookingDate BETWEEN ?1 AND ?2")
    List<Booking> fetchByDate(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT b FROM Booking b WHERE b.customerId = ?1")
    List<Booking> fetchByCustomerId(int custId);

    @Query(value = "SELECT b FROM Booking b WHERE b.photographerId = ?1")
    List<Booking> fetchByPhotographerId(int photoId);
}
