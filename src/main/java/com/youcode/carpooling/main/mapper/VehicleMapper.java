package com.youcode.carpooling.main.mapper;


import com.youcode.carpooling.main.dto.DriverRequest;
import com.youcode.carpooling.main.dto.VehicleRequest;
import com.youcode.carpooling.main.dto.VehicleResponse;
import com.youcode.carpooling.main.entities.Driver;
import com.youcode.carpooling.main.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
}
