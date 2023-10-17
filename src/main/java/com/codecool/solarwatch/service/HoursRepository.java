package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.Hours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoursRepository extends JpaRepository<Hours, Long> {
}
