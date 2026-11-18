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

    public List<TripResponse> getAll(){
        return tripRepository.findAll().stream().map(tripMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public TripResponse findById(Long id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trip " + id + " not found"));
        return tripMapper.toResponse(trip);
    }
}

