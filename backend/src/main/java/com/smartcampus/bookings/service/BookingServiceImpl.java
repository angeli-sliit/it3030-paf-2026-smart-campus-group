package com.smartcampus.bookings.service;

import com.smartcampus.bookings.repository.BookingRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of BookingService.
 * Member 2 will complete the business logic for booking workflow and conflict detection.
 */
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // TODO: Member 2 — Create booking (PENDING state)
    // TODO: Member 2 — Approve booking (conflict check first)
    // TODO: Member 2 — Reject booking (with reason)
    // TODO: Member 2 — Cancel booking
    // TODO: Member 2 — Get user's bookings
    // TODO: Member 2 — Get all bookings (Admin, with filters)
    // TODO: Member 2 — Time-overlap conflict detection algorithm
    // TODO: Member 2 — Auto-expire cron job (PENDING → EXPIRED after 24h)
}
