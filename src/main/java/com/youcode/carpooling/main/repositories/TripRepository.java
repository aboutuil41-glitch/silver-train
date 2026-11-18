package com.youcode.carpooling.main.repositories;

import com.youcode.carpooling.main.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
    boolean existsByVehicleId(Long vehicleId);
}
