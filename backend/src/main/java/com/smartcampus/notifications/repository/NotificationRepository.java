package com.smartcampus.notifications.repository;

import com.smartcampus.notifications.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for Notification entity.
 * Member 4 will add custom query methods.
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserIdOrderByCreatedAtDesc(Long userId);

    List<Notification> findByUserIdAndReadFalse(Long userId);
}
