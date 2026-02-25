package com.smartcampus.notifications.controller;

import com.smartcampus.notifications.service.NotificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for notification endpoints.
 * Member 4 will add GET /notifications, PUT /notifications/read, etc.
 */
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // TODO: Member 4 — GET /notifications (user's notifications)
    // TODO: Member 4 — PUT /notifications/read (mark all as read)
    // TODO: Member 4 — PUT /notifications/{id}/read (mark single as read)
}
