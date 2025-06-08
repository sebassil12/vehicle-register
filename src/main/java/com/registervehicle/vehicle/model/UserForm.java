package com.registervehicle.vehicle.model;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
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
public class UserForm {
    @NotBlank(message = "Name is required") // Ensures the name is not null and contains at least one non-whitespace character
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") // Defines length constraints for the name
    private String name;

    @NotBlank(message = "Email is required") // Ensures the email is not null and not just whitespace
    @Email(message = "Invalid email format") // Validates the email against a standard email format
    private String email;

    @Min(value = 18, message = "You must be at least 18 years old") // Ensures the age is at least 18
    private Integer age; // Using Integer to allow for null if no value is provided, though @NotNull could be added if it's strictly required

}
