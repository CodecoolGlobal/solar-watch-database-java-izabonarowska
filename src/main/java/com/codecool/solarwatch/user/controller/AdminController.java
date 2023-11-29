package com.codecool.solarwatch.user.controller;

import com.codecool.solarwatch.sun.model.Hours;
import com.codecool.solarwatch.sun.repository.HoursRepository;
import com.codecool.solarwatch.sun.service.HoursService;
import com.codecool.solarwatch.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final HoursService hoursService;

    public AdminController(UserService userService, HoursService hoursService) {
        this.userService = userService;
        this.hoursService = hoursService;
    }

    @GetMapping
    String adminPanel(Model model) {
        List<String> allUserEmails = userService.findAllUserEmails();
        model.addAttribute("userEmails", allUserEmails);

        List<Hours> hoursList = hoursService.getHoursWithCityInfo();
        model.addAttribute("hoursList", hoursList);

        return "admin";
    }

    @GetMapping("/delete-user")
    String deleteUser(@RequestParam String email) {
        userService.deleteUserByEmail(email);
        return "redirect:/admin";
    }

    @GetMapping("/hours/delete/{id}")
    public String deleteHour(@PathVariable Long id) {
        if (userService.isCurrentlyUserAdmin()) {
            hoursService.deleteById(id);
            return "redirect:/admin";
        }
        return "redirect:/error";
    }
}
