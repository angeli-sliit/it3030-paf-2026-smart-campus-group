package com.smartcampus.tickets.repository;

import com.smartcampus.tickets.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

