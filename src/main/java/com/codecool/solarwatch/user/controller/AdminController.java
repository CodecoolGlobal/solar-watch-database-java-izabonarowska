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
    private final HoursRepository hoursRepository;


    public AdminController(UserService userService, HoursService hoursService, HoursRepository hoursRepository) {
        this.userService = userService;
        this.hoursService = hoursService;
        this.hoursRepository = hoursRepository;
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

//    @PostMapping("/hours/update")
//    public String updateHour(@ModelAttribute Hours updatedHour) {
//        if (userService.isCurrentlyUserAdmin()) {
//            Hours existingHour = hoursService.getHoursWithCityInfo().stream().findById(updatedHour.getId()).orElse(null);
//            if (existingHour != null) {
//                existingHour.setDate(updatedHour.getDate());
//                existingHour.setSunrise(updatedHour.getSunrise());
//                existingHour.setSunset(updatedHour.getSunset());
//                hoursRepository.save(existingHour);
//            }
//            return "redirect:/admin";
//        }
//        return "redirect:/error";
//    }

}
