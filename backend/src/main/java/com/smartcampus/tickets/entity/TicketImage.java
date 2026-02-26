package com.smartcampus.tickets.entity;

import jakarta.persistence.*;

/**
 * Skeleton entity for ticket image attachments.
 */
@Entity
@Table(name = "ticket_images")
public class TicketImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}

