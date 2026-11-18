package com.youcode.carpooling.main.mapper;
import org.mapstruct.Mapper;
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
