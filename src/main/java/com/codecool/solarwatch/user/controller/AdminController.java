package com.codecool.solarwatch.user.controller;

import com.codecool.solarwatch.sun.model.City;
import com.codecool.solarwatch.sun.repository.CityRepository;
import com.codecool.solarwatch.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final CityRepository cityRepository;


    public AdminController(UserService userService, CityRepository cityRepository) {
        this.userService = userService;
        this.cityRepository = cityRepository;
    }

    @GetMapping
    String adminPanel(Model model) {
        List<String> allUserEmails = userService.findAllUserEmails();
        model.addAttribute("userEmails", allUserEmails);

        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);

        return "admin";
    }

    @GetMapping("/delete-user")
    String deleteUser(@RequestParam String email) {
        userService.deleteUserByEmail(email);
        return "redirect:/admin";
    }

    @GetMapping("/delete-city")
    String deleteCity(@RequestParam String city) {
        cityRepository.deleteCityByName(city);
        return "redirect:/admin";
    }

}
