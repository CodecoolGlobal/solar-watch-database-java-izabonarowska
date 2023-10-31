package com.codecool.solarwatch.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecuredController {
    @GetMapping("/secured")
    String homePage(){
        return "secured";
    }
}
