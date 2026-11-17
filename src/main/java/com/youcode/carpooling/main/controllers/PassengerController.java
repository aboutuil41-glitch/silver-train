package com.youcode.carpooling.main.controllers;


import com.youcode.carpooling.main.dto.DriverRequest;
import com.youcode.carpooling.main.dto.DriverResponse;
import com.youcode.carpooling.main.dto.PassengerRequest;
import com.youcode.carpooling.main.dto.PassengerResponse;
import com.youcode.carpooling.main.services.PassengerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    @PostMapping
    public ResponseEntity<PassengerResponse> create(@Valid @RequestBody PassengerRequest request){
        PassengerResponse response = passengerService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<PassengerResponse> getAll(){
        return passengerService.getAll();
    }

    @GetMapping("/{id}")
    public PassengerResponse findById(@PathVariable Long id){
        return passengerService.findById(id);
    }

    @GetMapping("/search")
    public PassengerResponse findByEmail(@RequestParam String email) {
        return passengerService.findByEmail(email);
    }
}
