package com.microservicio.bff_backend.controller;

import com.microservicio.bff_backend.model.EliminarPerfilDto;
import com.microservicio.bff_backend.model.Perfil;
import com.microservicio.bff_backend.model.ResponseModel;
import com.microservicio.bff_backend.service.perfil.PerfilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<Perfil> getAllPerfiles() {
        return perfilService.getAll();
    }

    @GetMapping("/{id}")
    public Perfil getPerfilById(@PathVariable Integer id) {
        return perfilService.getById(id);
    }

    @PostMapping
    public ResponseModel crearPerfil(@RequestBody Perfil perfil) {
        return perfilService.create(perfil);
    }

    @PutMapping("/{id}")
    public ResponseModel actualizarPerfil(@PathVariable Integer id, @RequestBody Perfil perfil) {
        return perfilService.update(id, perfil);
    }

    // @DeleteMapping("/{id}")
    // public ResponseModel eliminarPerfil(@PathVariable Integer id) {
    //     return perfilService.delete(id);
    // }

    @PostMapping("/eliminar-perfil")
    public ResponseModel eliminarPerfil(@RequestBody EliminarPerfilDto eliminarPerfilDto) {
        return perfilService.delete(eliminarPerfilDto);
    }
}
