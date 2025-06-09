package com.registervehicle.vehicle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registervehicle.vehicle.model.Vehicle;

import jakarta.validation.Valid;

@Controller
public class VehicleController {
    @GetMapping("/register-vehicle")
    public String showVehicleRegistrationForm(Model model) {
        // Add a new Vehicle object if not already present (e.g., after a redirect with errors)
        if (!model.containsAttribute("vehicle")) {
            model.addAttribute("vehicle", new Vehicle());
        }
        return "register-vehicle"; // Refers to register-vehicle.html
    }

    @PostMapping("/register-vehicle")
    public String processVehicleRegistration(@Valid @ModelAttribute("vehicle") Vehicle vehicle,
                                             BindingResult bindingResult,
                                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // If errors, add the vehicle object back to the model and return to the form
            // RedirectAttributes.addFlashAttribute ensures the model is available after redirect
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.vehicle", bindingResult);
            redirectAttributes.addFlashAttribute("vehicle", vehicle);
            return "redirect:/register-vehicle";
        }

        // If validation is successful, process the data (e.g., save to database)
        System.out.println("Vehicle registered successfully: " + vehicle);

        // Add a success message to display on the form after successful submission
        redirectAttributes.addFlashAttribute("successMessage", "Vehicle '" + vehicle.getPlateNumber() + "' registered successfully!");

        // Redirect back to the form or a success page
        return "redirect:/register-vehicle";
    }
}
