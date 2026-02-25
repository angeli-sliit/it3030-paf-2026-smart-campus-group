package com.smartcampus.tickets.repository;

import com.smartcampus.tickets.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

