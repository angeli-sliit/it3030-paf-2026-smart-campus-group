package com.smartcampus.tickets.entity;

import jakarta.persistence.*;

/**
 * Skeleton Ticket entity.
 * Member 3 will add fields and JPA annotations.
 */
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}

