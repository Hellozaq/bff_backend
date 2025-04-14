package com.microservicio.bff_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean(name = "usuariosWebClient")
    public WebClient usuariosWebClient(@Value("${backend.usuarios.url}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl + "/api/usuarios")
                .build();
    }

    @Bean(name = "perfilesWebClient")
    public WebClient perfilesWebClient(@Value("${backend.usuarios.url}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl + "/api/perfiles")
                .build();
    }

    @Bean(name = "autenticacionWebClient")
    public WebClient autenticacionWebClient(@Value("${backend.usuarios.url}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl + "/api/authentication")
                .build();
    }
}
