package com.smartcampus.bookings.dto;

import java.time.LocalDateTime;

public class BookingResponseDto {
    private Long id;
    private Long userId;
    private Long resourceId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String purpose;
    private Integer attendees;
    private String status;
    private String rejectionReason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getResourceId() { return resourceId; }
    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }
    public java.time.LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(java.time.LocalDateTime startTime) { this.startTime = startTime; }
    public java.time.LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(java.time.LocalDateTime endTime) { this.endTime = endTime; }
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public Integer getAttendees() { return attendees; }
    public void setAttendees(Integer attendees) { this.attendees = attendees; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
    public java.time.LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.time.LocalDateTime createdAt) { this.createdAt = createdAt; }
    public java.time.LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(java.time.LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // Getters and setters omitted for brevity
}
