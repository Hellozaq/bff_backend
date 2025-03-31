package com.microservicio.bff_backend.service.autenticacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservicio.bff_backend.model.AuthResponse;
import com.microservicio.bff_backend.model.LoginDto;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private WebClient autenticacionWebClient;

    @Override
    public ResponseEntity<AuthResponse> login(LoginDto loginDto) {
        return autenticacionWebClient.post()
                .uri("/login")
                .bodyValue(loginDto)
                .retrieve()
                .toEntity(AuthResponse.class)
                .block();
    }
} 