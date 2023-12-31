package com.codecool.solarwatch.sun.controller;

import com.codecool.solarwatch.sun.model.City;
import com.codecool.solarwatch.sun.model.SunDTO;
import com.codecool.solarwatch.sun.service.GeocodingService;
import com.codecool.solarwatch.sun.service.SunriseSunsetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/sun")
public class SunController {
    private final SunriseSunsetService sunriseSunsetService;
    private final GeocodingService geocodingService;

    public SunController(SunriseSunsetService sunriseSunsetService, GeocodingService geocodingService) {
        this.sunriseSunsetService = sunriseSunsetService;
        this.geocodingService = geocodingService;
    }

    @GetMapping()
    public ResponseEntity<Object> sunDTO(
            @RequestParam(name = "city", required = true) String city,
            @RequestParam(name = "date", required = true) String date
    ) {
        try{
            City cityObj = geocodingService.getLatitudeAndLongitude(city);
            SunDTO response = sunriseSunsetService.getSunriseAndSunset(cityObj, LocalDate.parse(date));
            return ResponseEntity.ok(response);
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

