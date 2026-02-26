package com.smartcampus.bookings.dto;

import java.time.LocalDateTime;

public class BookingRequestDto {
    private Long resourceId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String purpose;
    private Integer attendees;

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
}
