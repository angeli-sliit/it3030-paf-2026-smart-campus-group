package com.smartcampus.bookings.repository;

import com.smartcampus.bookings.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Find bookings for a resource that overlap a given time range (excluding CANCELLED/REJECTED/EXPIRED)
    @Query("SELECT b FROM Booking b WHERE b.resourceId = :resourceId AND b.status IN ('PENDING', 'APPROVED') AND b.startTime < :endTime AND b.endTime > :startTime")
    List<Booking> findConflictingBookings(@Param("resourceId") Long resourceId, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    // Find all bookings for a user
    List<Booking> findByUserIdOrderByStartTimeDesc(Long userId);

    // Admin: filter by status
    List<Booking> findByStatusOrderByStartTimeDesc(Booking.Status status);
}

