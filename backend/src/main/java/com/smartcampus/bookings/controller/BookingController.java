package com.smartcampus.bookings.controller;

import com.smartcampus.bookings.dto.BookingRequestDto;
import com.smartcampus.bookings.dto.BookingResponseDto;
import com.smartcampus.bookings.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponseDto> createBooking(@AuthenticationPrincipal(expression = "id") Long userId,
                                                           @RequestBody BookingRequestDto requestDto) {
        return ResponseEntity.ok(bookingService.createBooking(userId, requestDto));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<BookingResponseDto> approveBooking(@PathVariable Long id,
                                                            @AuthenticationPrincipal(expression = "id") Long adminId) {
        return ResponseEntity.ok(bookingService.approveBooking(id, adminId));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<BookingResponseDto> rejectBooking(@PathVariable Long id,
                                                           @AuthenticationPrincipal(expression = "id") Long adminId,
                                                           @RequestParam String reason) {
        return ResponseEntity.ok(bookingService.rejectBooking(id, adminId, reason));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<BookingResponseDto> cancelBooking(@PathVariable Long id,
                                                           @AuthenticationPrincipal(expression = "id") Long userId) {
        return ResponseEntity.ok(bookingService.cancelBooking(id, userId));
    }

    @GetMapping("/my")
    public ResponseEntity<List<BookingResponseDto>> getUserBookings(@AuthenticationPrincipal(expression = "id") Long userId) {
        return ResponseEntity.ok(bookingService.getUserBookings(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingResponseDto>> getAllBookings(@RequestParam(required = false) String status) {
        return ResponseEntity.ok(bookingService.getAllBookings(status));
    }
}

