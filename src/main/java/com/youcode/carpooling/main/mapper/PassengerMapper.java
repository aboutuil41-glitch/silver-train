package com.youcode.carpooling.main.mapper;


import com.youcode.carpooling.main.dto.DriverRequest;
import com.youcode.carpooling.main.dto.PassengerRequest;
import com.youcode.carpooling.main.dto.PassengerResponse;
import com.youcode.carpooling.main.entities.Driver;
import com.youcode.carpooling.main.entities.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

    PassengerResponse toResponse(Passenger passenger);

    @Mapping(target = "id", ignore = true)
    Passenger toEntity(PassengerRequest request);
}
