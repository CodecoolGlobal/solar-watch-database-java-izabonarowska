package com.codecool.solarwatch.sun.service;

import com.codecool.solarwatch.sun.model.City;
import com.codecool.solarwatch.sun.model.Hours;
import com.codecool.solarwatch.sun.repository.CityRepository;
import com.codecool.solarwatch.sun.repository.HoursRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoursService {

    private HoursRepository hoursRepository;

    private CityRepository cityRepository;

    public List<Hours> getHoursWithCityInfo() {
        List<Hours> hoursList = hoursRepository.findAll();

        for (Hours hour : hoursList) {
            City city = cityRepository.findById(hour.getCity().getId()).orElse(null);
            hour.setCity(city);
        }
        return hoursList;
    }

    public void deleteById(Long id) {
        hoursRepository.deleteById(id);
    }


}

