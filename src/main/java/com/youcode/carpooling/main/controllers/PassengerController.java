package com.youcode.carpooling.main.controllers;
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

}
