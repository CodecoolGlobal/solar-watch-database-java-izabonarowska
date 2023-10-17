package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.City;
import com.codecool.solarwatch.model.Coordinate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class GeocodingService {

    private final RestTemplate restTemplate;
    private final CityRepository cityRepository;

    public GeocodingService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
        this.restTemplate = new RestTemplate();
    }

    public Coordinate getLatitudeAndLongitude(String cityName) {
        Optional<City> cityOpt = cityRepository.findFirstByName(cityName);
        City city = cityOpt.orElseGet(() -> cityRepository.save(getCityFromExternalAPI(cityName)));
        return new Coordinate(city.getLongitude(), city.getLatitude());
    }

    private City getCityFromExternalAPI(String cityName) {
        String apiUrl = String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=1&appid=9f131dcdd89642165e122b41b461a2ff", cityName);
        String response = restTemplate.getForObject(apiUrl, String.class);
        JSONArray jsonArray = new JSONArray(response);
        if (jsonArray.isEmpty()) {
            throw new IllegalArgumentException("Błąd w nazwie miasta");
        }
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        String name = jsonObject.getString("name");
        String state = jsonObject.getString("state");
        String country = jsonObject.getString("country");
        double lat = jsonObject.getDouble("lat");
        double lon = jsonObject.getDouble("lon");
        return new City(name, lon, lat, state, country);
    }


}
