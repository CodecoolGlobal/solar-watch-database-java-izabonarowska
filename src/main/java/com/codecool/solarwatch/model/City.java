package com.codecool.solarwatch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double longitude;
    private double latitude;
    private String state;
    private String country;

    public City(String name, double longitude, double latitude, String state, String country) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.state = state;
        this.country = country;
    }
}
