package com.homedecorhub.authservice.controller;

import com.homedecorhub.authservice.model.User;
import com.homedecorhub.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = authService.register(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        return authService.login(loginRequest.getEmail(), loginRequest.getPassword())
                .<ResponseEntity<?>>map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.badRequest().body("Invalid Credentials"));
    }

}
