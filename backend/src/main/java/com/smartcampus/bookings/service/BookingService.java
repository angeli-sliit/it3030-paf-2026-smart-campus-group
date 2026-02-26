package com.smartcampus.bookings.service;

import com.smartcampus.bookings.dto.BookingRequestDto;
import com.smartcampus.bookings.dto.BookingResponseDto;
import java.util.List;

public interface BookingService {
    BookingResponseDto createBooking(Long userId, BookingRequestDto requestDto);
    BookingResponseDto approveBooking(Long bookingId, Long adminId);
    BookingResponseDto rejectBooking(Long bookingId, Long adminId, String reason);
    BookingResponseDto cancelBooking(Long bookingId, Long userId);
    List<BookingResponseDto> getUserBookings(Long userId);
    List<BookingResponseDto> getAllBookings(String status);
    void expirePendingBookings();
}

