package com.microservicio.bff_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient usuariosWebClient(@Value("${url.usuarios}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl + "/api/usuarios")
                .build();
    }

    @Bean
    public WebClient perfilesWebClient(@Value("${url.usuarios}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl + "/api/perfiles")
                .build();
    }

    @Bean
    public WebClient autenticacionWebClient(@Value("${url.usuarios}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl + "/api/authentication")
                .build();
    }
}