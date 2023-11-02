package com.codecool.solarwatch.user.controller;

import com.codecool.solarwatch.user.model.UserRegistrationDTO;
import com.codecool.solarwatch.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    String registrationForm(Model model) {
        UserRegistrationDTO user = new UserRegistrationDTO();
        model.addAttribute("user", user);
        return "registration-form";
    }

    @PostMapping("/register")
    String register(UserRegistrationDTO userRegistrationDto) {
        userService.register(userRegistrationDto);
        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    String registrationConfirmation() {
        return "registration-confirmation";
    }
}

