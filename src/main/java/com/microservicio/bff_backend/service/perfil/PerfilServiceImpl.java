package com.microservicio.bff_backend.service.perfil;

import com.microservicio.bff_backend.model.EliminarPerfilDto;
import com.microservicio.bff_backend.model.Perfil;
import com.microservicio.bff_backend.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private WebClient perfilesWebClient;

    @Override
    public List<Perfil> getAll() {
        return perfilesWebClient.get()
                .retrieve()
                .bodyToFlux(Perfil.class)
                .collectList()
                .block();
    }

    @Override
    public Perfil getById(Integer id) {
        return perfilesWebClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Perfil.class)
                .block();
    }

    @Override
    public ResponseModel create(Perfil perfil) {
        return perfilesWebClient.post()
                .bodyValue(perfil)
                .retrieve()
                .bodyToMono(ResponseModel.class)
                .block();
    }

    @Override
    public ResponseModel update(Integer id, Perfil perfil) {
        return perfilesWebClient.put()
                .uri("/{id}", id)
                .bodyValue(perfil)
                .retrieve()
                .bodyToMono(ResponseModel.class)
                .block();
    }

    @Override
    public ResponseModel delete(EliminarPerfilDto eliminarPerfilDto) {
        return perfilesWebClient.post()
            .uri("/delete-perfil")
            .bodyValue(eliminarPerfilDto)
            .retrieve()
            .bodyToMono(ResponseModel.class)
            .block();
    }
}