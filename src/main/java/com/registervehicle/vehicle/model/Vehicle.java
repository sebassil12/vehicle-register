package com.registervehicle.vehicle.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Vehicle {
    @NotBlank(message = "Número de placa es requeridp")
    @Pattern(regexp = "^[A-Z]{3}[- ]?[0-9]{3,4}$", message = "Formato inválido (e.g., ABC-123 o XYZ-1234)")
    private String plateNumber;

    @NotBlank(message = "Hecho en es requerido")
    @Size(min = 2, max = 50, message = "Debe tener entre 2 y 50 caracteres")
    private String make;

    @NotBlank(message = "Modelo es requerido")
    @Size(min = 2, max = 50, message = "Debe tener entre 2 y 50 caracteres")
    private String model;

    @Min(value = 1900, message = "El año debe ser desde 1900")
    @Max(value = 2025, message = "No puede ser de años futuros") // Assuming current year is 2025 as per instruction
    private Integer year;

    @NotBlank(message = "Color es requerido")
    @Size(min = 2, max = 30, message = "Debe tener entre 2 y 50 caracteres")
    private String color;
}
