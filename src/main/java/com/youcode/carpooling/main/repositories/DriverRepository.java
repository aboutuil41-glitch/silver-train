package com.youcode.carpooling.main.repositories;

import com.youcode.carpooling.main.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    boolean existsByEmail(String email);

}
