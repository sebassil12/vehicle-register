package com.registervehicle.vehicle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.registervehicle.vehicle.model.LoginUser;

import jakarta.validation.Valid;

@Controller
public class LoginController {
	 @GetMapping("/login")
	    public String showLoginForm(Model model) {
	        model.addAttribute("loginUser", new LoginUser());
	        return "login"; // Refers to login.html
	    }

    @PostMapping("/login")
    public String processLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "login"; // Stay on login page if validation fails
        }

        // Simple hardcoded authentication for demonstration
        if ("admin".equals(loginUser.getUsername()) && "admin".equals(loginUser.getPassword())) {
            // Successful login, redirect to vehicle registration page
            return "redirect:/register-vehicle";
        } else {
            // Failed login
            model.addAttribute("loginError", "Invalid username or password");
            return "login"; // Return to login page with an error
        }
    }
}
