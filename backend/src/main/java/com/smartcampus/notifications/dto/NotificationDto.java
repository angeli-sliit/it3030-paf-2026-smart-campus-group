package com.smartcampus.notifications.dto;

import java.time.LocalDateTime;

/**
 * DTO for Notification API payloads.
 */
public class NotificationDto {

    private Long id;
    private Long userId;
    private String type;
    private String message;
    private boolean read;
    private Long refId;
    private String refType;
    private LocalDateTime createdAt;

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }

    public Long getRefId() { return refId; }
    public void setRefId(Long refId) { this.refId = refId; }

    public String getRefType() { return refType; }
    public void setRefType(String refType) { this.refType = refType; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
