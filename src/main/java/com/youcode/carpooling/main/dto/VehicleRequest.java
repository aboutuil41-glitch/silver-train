package com.youcode.carpooling.main.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleRequest(
        @NotBlank String make,
        @NotBlank String model,
        @NotBlank String color,
        @NotBlank String registrationNumber,
        @Min(1) @Max(8) int capacity,
        @NotNull Long driverId
) {
}
