package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.Coordinate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodingService {

    private final RestTemplate restTemplate;

    public GeocodingService() {
        this.restTemplate = new RestTemplate();
    }

    public Coordinate getLatitudeAndLongitude(String city) {
        String apiUrl = String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=1&appid=9f131dcdd89642165e122b41b461a2ff", city);
        String response = restTemplate.getForObject(apiUrl, String.class);
        JSONArray jsonArray = new JSONArray(response);
        if (!jsonArray.isEmpty()) {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            double lat = jsonObject.getDouble("lat");
            double lon = jsonObject.getDouble("lon");
            return new Coordinate(lon, lat);
        }
        throw new IllegalArgumentException("Błąd w nazwie miasta");
    }
}
