package com.youcode.carpooling.main.controllers;
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
}
