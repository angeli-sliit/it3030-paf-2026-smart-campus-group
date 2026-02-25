package com.smartcampus.bookings.repository;

import com.smartcampus.bookings.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

