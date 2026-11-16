package com.youcode.carpooling.main.services;
import org.springframework.stereotype.Service;
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
    }

    public List<DriverResponse> getAll(){
        return driverRepository.findAll().stream()
                .map(driverMapper::toResponse)
                .toList();
    }

}
