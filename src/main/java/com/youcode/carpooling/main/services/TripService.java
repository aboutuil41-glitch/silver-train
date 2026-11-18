package com.youcode.carpooling.main.services;
public class TripService {
    private final TripRepository tripRepository;
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;
    private final TripMapper tripMapper;

    public TripService(TripRepository tripRepository, DriverRepository driverRepository,
                       VehicleRepository vehicleRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
        this.tripMapper = tripMapper;
    }

}

