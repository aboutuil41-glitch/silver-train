package com.youcode.carpooling.main.services;
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

}
