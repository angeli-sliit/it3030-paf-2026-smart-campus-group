package com.smartcampus.resources.repository;

import com.smartcampus.resources.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}

