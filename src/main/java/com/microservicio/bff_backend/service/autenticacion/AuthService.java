package com.microservicio.bff_backend.service.autenticacion;

import org.springframework.http.ResponseEntity;

import com.microservicio.bff_backend.model.AuthResponse;
import com.microservicio.bff_backend.model.LoginDto;

public interface AuthService {
    ResponseEntity<AuthResponse> login(LoginDto loginDto);
}