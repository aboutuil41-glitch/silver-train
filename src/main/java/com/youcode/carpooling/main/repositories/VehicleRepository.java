package com.youcode.carpooling.main.repositories;

import com.youcode.carpooling.main.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    boolean existsByRegistrationNumber(String registrationNumber);

    boolean existsByRegistrationNumberAndIdNot(String registrationNumber, Long id);

    List<Vehicle> findByDriver_Id(Long driverId);
}
