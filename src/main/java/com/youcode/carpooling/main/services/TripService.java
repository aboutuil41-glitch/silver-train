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

    @Transactional
    public TripResponse create(TripRequest request) {
        Driver driver = driverRepository.findById(request.driverId())
                .orElseThrow(() -> new ResourceNotFoundException("Driver " + request.driverId() + " not found"));

        Vehicle vehicle = vehicleRepository.findById(request.vehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle " + request.vehicleId() + " not found"));

        if (!vehicle.getDriver().getId().equals(driver.getId())) {
            throw new ForbiddenActionException("This vehicle belongs to another driver");
        }

        if (request.seatsOffered() > vehicle.getCapacity()) {
            throw new InvalidRequestException("Seats offered cannot exceed the vehicle capacity ("
                    + vehicle.getCapacity() + " seats maximum)");
        }

        if (!request.departureDate().isAfter(LocalDateTime.now())) {
            throw new InvalidRequestException("The departure must be in the future");
        }

        if (request.departureCity().trim().equalsIgnoreCase(request.arrivalCity().trim())) {
            throw new InvalidRequestException("Departure and arrival cities must be different");
        }

        Trip trip = tripMapper.toEntity(request);
        trip.setDriver(driver);
        trip.setVehicle(vehicle);
        return tripMapper.toResponse(tripRepository.save(trip));
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

