package com.youcode.carpooling.main.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TripRequest(
        @NotNull Long driverId,
        @NotNull Long vehicleId,
        @NotBlank String departureCity,
        @NotBlank String arrivalCity,
        @NotNull LocalDateTime departureDate,
        @Min(1) int seatsOffered
) {
}
