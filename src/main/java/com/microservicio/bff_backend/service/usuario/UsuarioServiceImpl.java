package com.microservicio.bff_backend.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservicio.bff_backend.model.ResponseModel;
import com.microservicio.bff_backend.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private WebClient usuariosWebClient;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuariosWebClient.get()
                .retrieve()
                .bodyToFlux(Usuario.class)
                .collectList()
                .block();
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return usuariosWebClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Usuario.class)
                .block();
    }

    @Override
    public ResponseModel crearUsuario(Usuario usuario) {
        return usuariosWebClient.post()
                .bodyValue(usuario)
                .retrieve()
                .bodyToMono(ResponseModel.class)
                .block();
    }

    @Override
    public ResponseModel actualizarUsuario(Integer id, Usuario usuario) {
        return usuariosWebClient.put()
                .uri("/{id}", id)
                .bodyValue(usuario)
                .retrieve()
                .bodyToMono(ResponseModel.class)
                .block();
    }

    @Override
    public ResponseModel eliminarUsuario(String email) {
        return usuariosWebClient.delete()
                .uri("/{email}", email)
                .retrieve()
                .bodyToMono(ResponseModel.class)
                .block();
    }

    @Override
    public ResponseModel asignarPerfil(Integer idUsuario, Integer idPerfil) {
        return usuariosWebClient.put()
                .uri("/{id}/perfil/{idPerfil}", idUsuario, idPerfil)
                .retrieve()
                .bodyToMono(ResponseModel.class)
                .block();
    }
}