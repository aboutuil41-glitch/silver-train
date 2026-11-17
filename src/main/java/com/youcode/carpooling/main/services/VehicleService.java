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

    public VehicleResponse create(VehicleRequest request){
        Driver driver = driverRepository.findById(request.driverId())
                .orElseThrow(() -> new ResourceNotFoundException("Driver " + request.driverId() + " not found"));


        if(vehicleRepository.existsByRegistrationNumber(request.registrationNumber())){
            throw new BusinessRuleException(request.registrationNumber() + " already exists");
        }


        Vehicle vehicle = vehicleMapper.toEntity(request);
        vehicle.setDriver(driver);
        System.out.println(vehicle.getDriver().getId());
        Vehicle created = vehicleRepository.save(vehicle);
        return vehicleMapper.toResponse(created);
    }

    public List<VehicleResponse> getAll(){
        return vehicleRepository.findAll().stream()
                .map(vehicleMapper::toResponse)
                .toList();
    }

}
