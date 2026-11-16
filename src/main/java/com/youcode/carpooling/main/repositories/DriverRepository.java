package com.youcode.carpooling.main.repositories;

import com.youcode.carpooling.main.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
