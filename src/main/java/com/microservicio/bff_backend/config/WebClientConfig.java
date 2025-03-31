package com.microservicio.bff_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient usuariosWebClient() {
        return WebClient.builder().baseUrl("http://localhost:8085/api/usuarios").build();
    }

    @Bean
    public WebClient perfilesWebClient() {
        return WebClient.builder().baseUrl("http://localhost:8085/api/perfiles").build();
    }
}
