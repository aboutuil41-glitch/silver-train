package com.youcode.carpooling.main.dto;

import com.youcode.carpooling.main.enums.StatutTrajet;

import java.time.LocalDateTime;

public record TripResponse(
        Long id,
        Long driverId,
        Long vehicleId,
        String departureCity,
        String arrivalCity,
        LocalDateTime departureDate,
        int seatsOffered,
        int remainingSeats,
        StatutTrajet statut
) {
}
