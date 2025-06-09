package com.registervehicle.vehicle.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class LoginUser {
    @NotBlank(message = "Usuario es requerido")
    @Size(min = 3, max = 20, message = "Usuario debe tener entre 3 y 20 caracteres")
    private String username;

    @NotBlank(message = "Contraseña es requerida")
    @Size(min = 5, max = 30, message = "Contraseña debe tener entre 3 y 20 caracteres")
    private String password;
}
