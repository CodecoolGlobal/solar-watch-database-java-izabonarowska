package com.codecool.solarwatch.sun.repository;

import com.codecool.solarwatch.sun.model.City;
import com.codecool.solarwatch.sun.model.Hours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface HoursRepository extends JpaRepository<Hours, Long> {
    Optional<Hours> findFirstByCityAndDate(City city, LocalDate date);
}
