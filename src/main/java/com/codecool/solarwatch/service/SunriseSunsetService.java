package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.Coordinate;
import com.codecool.solarwatch.model.SunDTO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SunriseSunsetService {
    private final RestTemplate restTemplate;

    public SunriseSunsetService() {
        this.restTemplate = new RestTemplate();
    }

    public SunDTO getSunriseAndSunset(Coordinate location, String date) {
        double lng = location.longitude();
        double lat = location.latitude();
        String apiUrl = String.format("https://api.sunrise-sunset.org/json?lat=%f&lng=%f&date=%s", lat, lng, date);
        String response = restTemplate.getForObject(apiUrl, String.class);

        JSONObject jsonObject = new JSONObject(response);
        JSONObject results = jsonObject.getJSONObject("results");

        String sunrise = results.getString("sunrise");
        String sunset = results.getString("sunset");

        return new SunDTO(sunrise, sunset);
    }
}
