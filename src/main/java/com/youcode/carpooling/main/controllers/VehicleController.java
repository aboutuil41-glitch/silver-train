package com.youcode.carpooling.main.controllers;


import com.youcode.carpooling.main.dto.DriverRequest;
import com.youcode.carpooling.main.dto.DriverResponse;
import com.youcode.carpooling.main.dto.VehicleRequest;
import com.youcode.carpooling.main.dto.VehicleResponse;
import com.youcode.carpooling.main.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> create(@Valid @RequestBody VehicleRequest request){
        VehicleResponse response = vehicleService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<VehicleResponse> getAll(){
        return vehicleService.getAll();
    }

    @GetMapping("/driver/{id}")
    public List<VehicleResponse> findById(@PathVariable Long id){
        return vehicleService.getByDriver(id);
    }

    @PutMapping("/{id}")
    public VehicleResponse update(@PathVariable Long id, @Valid @RequestBody VehicleRequest request) {
        return vehicleService.update(id, request);
    }

}
