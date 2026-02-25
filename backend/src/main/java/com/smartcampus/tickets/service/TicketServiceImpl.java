package com.smartcampus.tickets.service;

import com.smartcampus.tickets.repository.CommentRepository;
import com.smartcampus.tickets.repository.TicketImageRepository;
import com.smartcampus.tickets.repository.TicketRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of TicketService.
 * Member 3 will complete the business logic for incident tickets, SLA, and comments.
 */
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final CommentRepository commentRepository;
    private final TicketImageRepository ticketImageRepository;

    public TicketServiceImpl(TicketRepository ticketRepository,
                             CommentRepository commentRepository,
                             TicketImageRepository ticketImageRepository) {
        this.ticketRepository = ticketRepository;
        this.commentRepository = commentRepository;
        this.ticketImageRepository = ticketImageRepository;
    }

    // TODO: Member 3 — Create ticket (OPEN state)
    // TODO: Member 3 — List tickets (role-filtered)
    // TODO: Member 3 — Update ticket status (workflow: OPEN → IN_PROGRESS → RESOLVED → CLOSED)
    // TODO: Member 3 — Assign technician
    // TODO: Member 3 — Add comment (with ownership rules)
    // TODO: Member 3 — Upload images (up to 3, validate type + size)
    // TODO: Member 3 — SLA: track first_response_at and resolved_at timestamps
}
