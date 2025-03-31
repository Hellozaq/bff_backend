package com.microservicio.bff_backend.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Usuario {

    private int idUsuario;

    @NotNull
    @Size(min = 2, max = 100, message = "Debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotNull
    @Size(min = 2, max = 50, message = "Debe tener entre 2 y 100 caracteres")
    private String apellidoPaterno;

    @NotNull
    @Size(min = 2, max = 50, message = "Debe tener entre 2 y 100 caracteres")
    private String apellidoMaterno;

    @NotNull
    @Size(max = 50, message = "Debe tener un máximo de 50 caracteres")
    @Email(message = "El email debe tener un formato válido")
    private String email;

    @Size(min = 6, max = 20, message = "La contraseña debe contener entre 6 y 20 caracteres con al menos una letra y un número")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,20}$", message = "La contraseña debe contener entre 6 y 20 caracteres con al menos una letra y un número")
    private String contrasena;

    @Size(min = 9, max = 9, message = "Debe tener 9 dígitos")
    @Pattern(regexp = "\\d{9}", message = "Debe contener solo dígitos")
    private String telefono;

    @NotNull
    @Size(min = 2, max = 255, message = "Debe tener entre 2 y 255 caracteres")
    private String direccion;

    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private LocalDate fechaNacimiento;
}