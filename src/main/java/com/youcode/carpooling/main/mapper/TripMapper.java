package com.youcode.carpooling.main.mapper;


import com.youcode.carpooling.main.dto.TripRequest;
import com.youcode.carpooling.main.dto.TripResponse;
import com.youcode.carpooling.main.entities.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TripMapper {

    @Mapping(source = "driver.id", target = "driverId")
    @Mapping(source = "vehicle.id", target = "vehicleId")
    @Mapping(target = "remainingSeats", expression = "java(trip.getSeatsOffered())")
    TripResponse toResponse(Trip trip);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "driver", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "statut", ignore = true)
    Trip toEntity(TripRequest request);
}
