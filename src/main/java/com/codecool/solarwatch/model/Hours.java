package com.codecool.solarwatch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Hours {
    @Id
    private long id;
    private LocalDate date;
    private String sunrise;
    private String sunset;
    @ManyToOne
    private City city;
}
