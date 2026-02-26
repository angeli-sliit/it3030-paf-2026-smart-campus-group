package com.smartcampus.resources.entity;

import jakarta.persistence.*;

/**
 * Skeleton Resource entity for facilities and equipment.
 * Fields and JPA annotations will be added by Member 1.
 */
@Entity
@Table(name = "resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}

