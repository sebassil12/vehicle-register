package com.registervehicle.vehicle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.registervehicle.vehicle.model.UserForm;

import jakarta.validation.Valid;

@Controller
public class UserFormController {

    /**
     * Handles GET requests to display the user input form.
     * Initializes a new UserForm object and adds it to the model for Thymeleaf.
     * @param model The Spring Model to add attributes to.
     * @return The name of the Thymeleaf template (user-form.html).
     */
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm()); // Add an empty form object to the model
        return "user-form"; // Return the name of the template
    }

    /**
     * Handles POST requests when the user submits the form.
     * Validates the submitted UserForm data.
     * If validation errors exist, returns to the form page to display errors.
     * If validation is successful, redirects to a success page.
     * @param userForm The UserForm object populated with submitted data. @Valid triggers validation.
     * @param bindingResult Holds the results of the validation (errors).
     * @param model The Spring Model to add attributes to.
     * @return Redirects to success or returns to the form page.
     */
    @PostMapping("/submit-form")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm,
                             BindingResult bindingResult,
                             Model model) {
        // Check if there are any validation errors
        if (bindingResult.hasErrors()) {
            // If errors exist, return to the form page.
            // Thymeleaf will automatically display the error messages associated with the fields.
            return "user-form";
        }

        // If validation is successful, you can process the data (e.g., save to database)
        // For this example, we'll just log it and redirect to a success page.
        System.out.println("Form submitted successfully: " + userForm);

        // Add a success message or the submitted data to the model for the success page
        model.addAttribute("submittedUser", userForm);

        // Redirect to a success page
        return "redirect:/success";
    }

    /**
     * Handles GET requests for the success page after form submission.
     * @return The name of the Thymeleaf template (success.html).
     */
    @GetMapping("/success")
    public String showSuccessPage(Model model) {
        // You can retrieve the submittedUser from the session or pass it via URL parameters
        // For simplicity, let's assume it was already handled or we'll display a generic message.
        if (!model.containsAttribute("submittedUser")) {
             model.addAttribute("submittedUser", new UserForm("Guest", "N/A", 0)); // Fallback
        }
        return "success";
    }
}