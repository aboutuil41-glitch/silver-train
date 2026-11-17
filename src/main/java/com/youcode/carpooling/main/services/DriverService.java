package com.youcode.carpooling.main.services;

import com.youcode.carpooling.main.dto.DriverRequest;
import com.youcode.carpooling.main.dto.DriverResponse;
import com.youcode.carpooling.main.entities.Driver;
import com.youcode.carpooling.main.mapper.DriverMapper;
import com.youcode.carpooling.main.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    DriverService(DriverRepository driverRepository, DriverMapper driverMapper){
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    public DriverResponse create(DriverRequest request){
        Driver driver = driverMapper.toEntity(request);
        Driver saved = driverRepository.save(driver);
        return  driverMapper.toResponse(saved);
        Driver created = driverRepository.save(driver);
        return  driverMapper.toResponse(created);
    }

    public List<DriverResponse> getAll(){
        return driverRepository.findAll().stream()
                .map(driverMapper::toResponse)
                .toList();
    }

    public DriverResponse findById(Long id){
        Driver driver = driverRepository.findById(id).orElse(null);
        return driverMapper.toResponse(driver);
    }

}
