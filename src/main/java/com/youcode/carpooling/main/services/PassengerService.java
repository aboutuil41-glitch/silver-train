package com.youcode.carpooling.main.services;

import com.youcode.carpooling.common.exceptions.BusinessRuleException;
import com.youcode.carpooling.common.exceptions.ResourceNotFoundException;
import com.youcode.carpooling.main.dto.PassengerRequest;
import com.youcode.carpooling.main.dto.PassengerResponse;
import com.youcode.carpooling.main.entities.Passenger;
import com.youcode.carpooling.main.mapper.PassengerMapper;
import com.youcode.carpooling.main.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;

    PassengerService(PassengerRepository passengerRepository, PassengerMapper passengerMapper) {
        this.passengerRepository = passengerRepository;
        this.passengerMapper = passengerMapper;
    }

    public PassengerResponse create(PassengerRequest request){
        if (passengerRepository.existsByEmail(request.email()))
            throw new BusinessRuleException("A passenger with email " + request.email() + " already exists");

        Passenger passenger = passengerMapper.toEntity(request);
        Passenger created = passengerRepository.save(passenger);
        return  passengerMapper.toResponse(created);
    }

    public List<PassengerResponse> getAll(){
        return passengerRepository.findAll().stream()
                .map(passengerMapper::toResponse)
                .toList();
    }

    public PassengerResponse findById(Long id){
        Passenger passenger = passengerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Driver " + id + " not found"));
        return passengerMapper.toResponse(passenger);
    }

    public PassengerResponse findByEmail(String email) {
        Passenger passenger = passengerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger with email " + email + " not found"));
        return passengerMapper.toResponse(passenger);
    }

}
