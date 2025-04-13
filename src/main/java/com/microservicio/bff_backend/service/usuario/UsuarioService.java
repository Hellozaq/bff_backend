package com.microservicio.bff_backend.service.usuario;

import java.util.List;

import com.microservicio.bff_backend.model.ResponseModel;
import com.microservicio.bff_backend.model.Usuario;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer id);
    ResponseModel crearUsuario(Usuario usuario);
    ResponseModel actualizarUsuario(Integer id, Usuario usuario);
    ResponseModel cambiarContrasena(String nuevaContrasena, String token);
    ResponseModel eliminarUsuario(String email);
    ResponseModel asignarPerfil(Integer idUsuario, Integer idPerfil);
    List<Usuario> getUsuariosPorPerfil(String nombrePerfil);//GraphQL

}