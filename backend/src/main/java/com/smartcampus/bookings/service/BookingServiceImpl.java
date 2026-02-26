package com.smartcampus.bookings.service;

import com.smartcampus.bookings.dto.BookingRequestDto;
import com.smartcampus.bookings.dto.BookingResponseDto;
import com.smartcampus.bookings.entity.Booking;
import com.smartcampus.bookings.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    @Transactional
    public BookingResponseDto createBooking(Long userId, BookingRequestDto requestDto) {
        // Conflict detection
        List<Booking> conflicts = bookingRepository.findConflictingBookings(
                requestDto.getResourceId(), requestDto.getStartTime(), requestDto.getEndTime());
        if (!conflicts.isEmpty()) {
            throw new RuntimeException("Booking conflict detected for the selected time range.");
        }
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setResourceId(requestDto.getResourceId());
        booking.setStartTime(requestDto.getStartTime());
        booking.setEndTime(requestDto.getEndTime());
        booking.setPurpose(requestDto.getPurpose());
        booking.setAttendees(requestDto.getAttendees());
        booking.setStatus(Booking.Status.PENDING);
        bookingRepository.save(booking);
        return toResponseDto(booking);
    }

    @Override
    @Transactional
    public BookingResponseDto approveBooking(Long bookingId, Long adminId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(Booking.Status.APPROVED);
        bookingRepository.save(booking);
        return toResponseDto(booking);
    }

    @Override
    @Transactional
    public BookingResponseDto rejectBooking(Long bookingId, Long adminId, String reason) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(Booking.Status.REJECTED);
        booking.setRejectionReason(reason);
        bookingRepository.save(booking);
        return toResponseDto(booking);
    }

    @Override
    @Transactional
    public BookingResponseDto cancelBooking(Long bookingId, Long userId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        if (!booking.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized");
        }
        booking.setStatus(Booking.Status.CANCELLED);
        bookingRepository.save(booking);
        return toResponseDto(booking);
    }

    @Override
    public List<BookingResponseDto> getUserBookings(Long userId) {
        return bookingRepository.findByUserIdOrderByStartTimeDesc(userId)
                .stream().map(this::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<BookingResponseDto> getAllBookings(String status) {
        if (status == null) {
            return bookingRepository.findAll().stream().map(this::toResponseDto).collect(Collectors.toList());
        }
        return bookingRepository.findByStatusOrderByStartTimeDesc(Booking.Status.valueOf(status))
                .stream().map(this::toResponseDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void expirePendingBookings() {
        List<Booking> pending = bookingRepository.findByStatusOrderByStartTimeDesc(Booking.Status.PENDING);
        LocalDateTime now = LocalDateTime.now();
        for (Booking booking : pending) {
            if (booking.getCreatedAt().plusHours(24).isBefore(now)) {
                booking.setStatus(Booking.Status.EXPIRED);
                bookingRepository.save(booking);
            }
        }
    }

    private BookingResponseDto toResponseDto(Booking booking) {
        BookingResponseDto dto = new BookingResponseDto();
        dto.setId(booking.getId());
        dto.setUserId(booking.getUserId());
        dto.setResourceId(booking.getResourceId());
        dto.setStartTime(booking.getStartTime());
        dto.setEndTime(booking.getEndTime());
        dto.setPurpose(booking.getPurpose());
        dto.setAttendees(booking.getAttendees());
        dto.setStatus(booking.getStatus().name());
        dto.setRejectionReason(booking.getRejectionReason());
        dto.setCreatedAt(booking.getCreatedAt());
        dto.setUpdatedAt(booking.getUpdatedAt());
        return dto;
    }
}
