package com.codecool.solarwatch.sun.controller;

import org.springframework.security.core.Authentication;
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
