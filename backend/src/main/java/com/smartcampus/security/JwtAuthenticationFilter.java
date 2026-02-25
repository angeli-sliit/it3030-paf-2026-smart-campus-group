package com.smartcampus.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JWT authentication filter skeleton.
 * Intercepts every request to validate the JWT token from the Authorization header.
 * Member 4 will implement full token parsing, validation, and SecurityContext setup.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // TODO: Member 4 — Extract JWT from Authorization header
        // TODO: Member 4 — Validate token signature and expiration
        // TODO: Member 4 — Extract userId and roles from token claims
        // TODO: Member 4 — Set authenticated principal in SecurityContextHolder

        // For now, just pass through
        filterChain.doFilter(request, response);
    }
}
