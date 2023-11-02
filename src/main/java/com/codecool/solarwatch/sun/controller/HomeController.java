package com.codecool.solarwatch.sun.controller;

import com.codecool.solarwatch.sun.model.City;
import com.codecool.solarwatch.sun.model.SunDTO;
import com.codecool.solarwatch.sun.service.GeocodingService;
import com.codecool.solarwatch.sun.service.SunriseSunsetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/")
    String home(){
       return "index.html";
    }
}
