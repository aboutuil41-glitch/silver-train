package com.youcode.carpooling.main.dto;

public record DriverResponse(
        Long id,
        String lastName,
        String firstName,
        String email,
        String phone,
        String licenseNumber
) {}