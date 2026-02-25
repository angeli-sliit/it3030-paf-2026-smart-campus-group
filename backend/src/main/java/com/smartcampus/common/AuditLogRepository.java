package com.smartcampus.common;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for AuditLog entity.
 * Member 4 will add custom query methods for filtering.
 */
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findAllByOrderByPerformedAtDesc();

    List<AuditLog> findByActorId(Long actorId);

    List<AuditLog> findByEntityTypeAndEntityId(String entityType, Long entityId);
}
