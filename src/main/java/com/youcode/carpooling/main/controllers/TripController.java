package com.youcode.carpooling.main.controllers;


import com.youcode.carpooling.main.dto.TripRequest;
import com.youcode.carpooling.main.dto.TripResponse;
import com.youcode.carpooling.main.services.TripService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping
    public ResponseEntity<TripResponse> create(@Valid @RequestBody TripRequest request){
        TripResponse response = tripService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<TripResponse> getAll(){
        return tripService.getAll();
    }

    @GetMapping("/{id}")
    public TripResponse findById(@PathVariable Long id){
        return tripService.findById(id);
    }
}
