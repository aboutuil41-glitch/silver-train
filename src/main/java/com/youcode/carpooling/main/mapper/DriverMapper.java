package com.youcode.carpooling.main.mapper;


import com.youcode.carpooling.main.dto.DriverRequest;
import com.youcode.carpooling.main.dto.DriverResponse;
import com.youcode.carpooling.main.entities.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    DriverResponse toResponse(Driver driver);

    @Mapping(target = "id", ignore = true)
    Driver toEntity(DriverRequest request);

    @Mapping(target = "id", ignore = true)
    void updateEntity(DriverRequest request, @MappingTarget Driver driver);
}