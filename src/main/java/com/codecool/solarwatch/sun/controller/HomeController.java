package com.codecool.solarwatch.sun.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    String home(Authentication authentication){
        System.out.println(authentication);
       return "index";
    }
}
