package com.microservicio.bff_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.bff_backend.model.ResponseModel;
import com.microservicio.bff_backend.model.Usuario;
import com.microservicio.bff_backend.service.usuario.UsuarioService;

@RestController
@RequestMapping("/bff/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public ResponseModel crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseModel actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    @PutMapping("/cambiar-contrasena")
    public ResponseModel cambiarContrasena(@RequestBody String nuevaContrasena, @RequestHeader("Authorization") String token) {
        return usuarioService.cambiarContrasena(nuevaContrasena, token);
    }

    @DeleteMapping("/{email}")
    public ResponseModel eliminarUsuario(@PathVariable String email) {
        return usuarioService.eliminarUsuario(email);
    }

    @PutMapping("/{id}/perfil/{idPerfil}")
    public ResponseModel asignarPerfil(@PathVariable Integer id, @PathVariable Integer idPerfil) {
        return usuarioService.asignarPerfil(id, idPerfil);
    }
}