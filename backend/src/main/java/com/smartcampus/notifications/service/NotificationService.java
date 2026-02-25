package com.smartcampus.notifications.service;

import com.smartcampus.notifications.dto.NotificationDto;

import java.util.List;

/**
 * Service interface for notification operations.
 * Member 4 will implement the full logic.
 */
public interface NotificationService {

    List<NotificationDto> getUserNotifications(Long userId);

    void markAsRead(Long notificationId);

    void markAllAsRead(Long userId);

    void notifyUser(Long userId, String type, String message, Long refId, String refType);
}
