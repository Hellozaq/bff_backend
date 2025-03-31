package com.microservicio.bff_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservicio.bff_backend.model.AuthResponse;
import com.microservicio.bff_backend.model.LoginDto;
import com.microservicio.bff_backend.service.autenticacion.AuthService;

@RestController
@RequestMapping("/bff/auth")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }
}