package com.youcode.carpooling.main.dto;

public record PassengerResponse(
        Long id,
        String lastName,
        String firstName,
        String email,
        String phone
) {
}
