package com.youcode.carpooling.main.services;
@Service
public class VehicleService {
    private final VehicleMapper vehicleMapper;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;

    public VehicleService(VehicleMapper vehicleMapper, VehicleRepository vehicleRepository,
                          DriverRepository driverRepository) {
        this.vehicleMapper = vehicleMapper;
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }
}
