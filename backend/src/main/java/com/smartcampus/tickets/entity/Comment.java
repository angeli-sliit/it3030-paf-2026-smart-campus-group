package com.smartcampus.tickets.entity;

import jakarta.persistence.*;

/**
 * Skeleton entity for ticket comments.
 */
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}

