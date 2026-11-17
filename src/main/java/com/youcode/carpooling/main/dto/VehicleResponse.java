package com.youcode.carpooling.main.dto;

public record VehicleResponse(
        Long id,
        String make,
        String model,
        String color,
        String registrationNumber,
        int capacity,
        Long driverId
) {
}
