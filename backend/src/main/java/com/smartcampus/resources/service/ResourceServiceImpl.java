package com.smartcampus.resources.service;

import com.smartcampus.resources.repository.ResourceRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of ResourceService.
 * Member 1 will complete the business logic for facilities & assets.
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    // TODO: Member 1 — Create resource
    // TODO: Member 1 — Update resource
    // TODO: Member 1 — Delete resource
    // TODO: Member 1 — List all resources (paginated)
    // TODO: Member 1 — Search resources (type, capacity, location)
    // TODO: Member 1 — Get resource availability
    // TODO: Member 1 — Analytics: top resources, peak hours
}
