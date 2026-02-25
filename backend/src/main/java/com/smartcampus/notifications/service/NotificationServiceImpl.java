package com.smartcampus.notifications.service;

import com.smartcampus.notifications.dto.NotificationDto;
import com.smartcampus.notifications.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of NotificationService.
 * Member 4 will complete the business logic.
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<NotificationDto> getUserNotifications(Long userId) {
        // TODO: Member 4 — fetch and map notifications for this user
        return List.of();
    }

    @Override
    public void markAsRead(Long notificationId) {
        // TODO: Member 4 — mark single notification as read
    }

    @Override
    public void markAllAsRead(Long userId) {
        // TODO: Member 4 — mark all notifications as read for user
    }

    @Override
    public void notifyUser(Long userId, String type, String message, Long refId, String refType) {
        // TODO: Member 4 — create and persist a new notification
    }
}
