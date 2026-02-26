package com.smartcampus.auth.controller;


import com.smartcampus.users.entity.User;
import com.smartcampus.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartcampus.auth.jwt.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User registeredUser = userService.register(user.getUsername(), user.getPassword(), "USER");
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        User existingUser = userService.findByUsername(user.getUsername());

        if (existingUser == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        if (!userService.passwordMatches(user.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(existingUser.getUsername());
        return ResponseEntity.ok(token);
    }
}
