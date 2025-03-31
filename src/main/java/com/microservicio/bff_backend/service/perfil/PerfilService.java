package com.microservicio.bff_backend.service.perfil;

import com.microservicio.bff_backend.model.Perfil;
import com.microservicio.bff_backend.model.ResponseModel;

import java.util.List;

public interface PerfilService {
    List<Perfil> getAll();
    Perfil getById(Integer id);
    ResponseModel create(Perfil perfil);
    ResponseModel update(Integer id, Perfil perfil);
    ResponseModel delete(Integer id);
}
