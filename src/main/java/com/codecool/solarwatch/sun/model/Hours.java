package com.codecool.solarwatch.sun.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private String sunrise;
    private String sunset;
    @ManyToOne
    private City city;

    public Hours(LocalDate date, String sunrise, String sunset, City city) {
        this.date = date;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.city = city;
    }
}
