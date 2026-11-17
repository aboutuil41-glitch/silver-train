package com.youcode.carpooling.main.services;

import com.youcode.carpooling.common.exceptions.BusinessRuleException;
import com.youcode.carpooling.common.exceptions.ResourceNotFoundException;
import com.youcode.carpooling.main.dto.DriverRequest;
import com.youcode.carpooling.main.dto.DriverResponse;
import com.youcode.carpooling.main.entities.Driver;
import com.youcode.carpooling.main.mapper.DriverMapper;
import com.youcode.carpooling.main.repositories.DriverRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (driverRepository.existsByEmail(request.email()))
            throw new BusinessRuleException("A driver with email " + request.email() + " already exists");

        if (driverRepository.existsByLicenseNumber(request.licenseNumber()))
            throw new BusinessRuleException("A driver with license number " + request.licenseNumber() + " already exists");

        Driver driver = driverMapper.toEntity(request);
        Driver created = driverRepository.save(driver);
        return  driverMapper.toResponse(created);
    }

    public List<DriverResponse> getAll(){
        return driverRepository.findAll().stream()
                .map(driverMapper::toResponse)
                .toList();
    }

    public DriverResponse findById(Long id){
        Driver driver = driverRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Driver " + id + " not found"));
        return driverMapper.toResponse(driver);
    }

    @Transactional
    public DriverResponse update(Long id, DriverRequest request) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver " + id + " not found"));

        if (driverRepository.existsByEmailAndIdNot(request.email(), id))
            throw new BusinessRuleException("Email " + request.email() + " is already used by another driver");

        if (driverRepository.existsByLicenseNumberAndIdNot(request.licenseNumber(), id))
            throw new BusinessRuleException("License number " + request.licenseNumber() + " is already used by another driver");

        driverMapper.updateEntity(request, driver);
        return driverMapper.toResponse(driverRepository.save(driver));
    }

    public List<DriverResponse> search(String q) {
        return driverRepository
                .findByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrEmailContainingIgnoreCase(q, q, q)
                .stream()
                .map(driverMapper::toResponse)
                .toList();
    }

}
