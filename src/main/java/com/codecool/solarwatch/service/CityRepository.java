package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findFirstByName(String name);
}
