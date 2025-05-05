package com.microservicio.bff_backend.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CambioContrasenaDto {
    private String nuevaContrasena;
}
