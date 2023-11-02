package com.codecool.solarwatch.sun.repository;

import com.codecool.solarwatch.sun.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findFirstByName(String name);

    void deleteCityByName(String city);
}
