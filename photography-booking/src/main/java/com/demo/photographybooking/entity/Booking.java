package com.demo.photographybooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_date", nullable = false)
    private String bookingDate;

    @Column(name = "customerId", nullable = false)
    private String customerId;

    @Column(name = "photographerId", nullable = false)
    private String photographerId;


}
