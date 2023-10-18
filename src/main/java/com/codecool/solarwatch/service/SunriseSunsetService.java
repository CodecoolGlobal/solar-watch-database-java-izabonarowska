package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.City;
import com.codecool.solarwatch.model.Coordinate;
import com.codecool.solarwatch.model.Hours;
import com.codecool.solarwatch.model.SunDTO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SunriseSunsetService {
    private final RestTemplate restTemplate;
    private final HoursRepository hoursRepository;

    public SunriseSunsetService(HoursRepository hoursRepository) {
        this.hoursRepository = hoursRepository;
        this.restTemplate = new RestTemplate();
    }

    public SunDTO getSunriseAndSunset(City city, LocalDate date) {
        Optional<Hours> hoursOpt = hoursRepository.findFirstByCityAndDate(city, date);
        Hours hours = hoursOpt.orElseGet(() -> hoursRepository.save(getHoursFromExternalAPI(city, date)));
        return new SunDTO(hours.getSunrise(), hours.getSunset());
    }

    private Hours getHoursFromExternalAPI(City city, LocalDate date) {
        double lng = city.getLongitude();
        double lat = city.getLatitude();
        String apiUrl = String.format("https://api.sunrise-sunset.org/json?lat=%f&lng=%f&date=%s", lat, lng, date.toString());
        String response = restTemplate.getForObject(apiUrl, String.class);
        JSONObject jsonObject = new JSONObject(response);
        JSONObject results = jsonObject.getJSONObject("results");
        String sunrise = results.getString("sunrise");
        String sunset = results.getString("sunset");
        return new Hours(date, sunrise, sunset, city);
    }
}
