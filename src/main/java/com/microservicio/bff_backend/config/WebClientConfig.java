package com.microservicio.bff_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean(name = "usuariosWebClient")
    public WebClient usuariosWebClient(@Value("${url.usuarios}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl + "/api/usuarios")
                .build();
    }

    @Bean(name = "perfilesWebClient")
    public WebClient perfilesWebClient(@Value("${url.usuarios}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl + "/api/perfiles")
                .build();
    }

    @Bean(name = "autenticacionWebClient")
    public WebClient autenticacionWebClient(@Value("${url.usuarios}") String baseUrl) {
        System.out.println("➡️ autenticacionWebClient cargado con: " + baseUrl + "/api/authentication");
        return WebClient.builder()
                .baseUrl(baseUrl + "/api/authentication")
                .build();
    }
}
