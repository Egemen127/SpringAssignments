package org.genspark.Controller;

import org.genspark.Entity.Flight;
import org.genspark.Entity.Passenger;
import org.genspark.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private FlightService service;

    @GetMapping("/")
    public String home(@RequestParam(value="name", defaultValue="User") String name){
        return "<HTML><h1>Hello "+name+"! This is my first Rest API in Spring Boot</h1><HTML>";
    }

    @GetMapping("/flights")
    public List<Flight> getFlights(){
    return this.service.getAllFlights();
    }
    @GetMapping("/flights/{flightId}")
    public Flight getFlight(@PathVariable String flightId){
        return this.service.getFlightById(Integer.parseInt(flightId));
    }
    @PostMapping("/flights")
    public Flight addFlight(@RequestBody Flight flight){
        return this.service.addFlight(flight);

    }
    @PutMapping("/flights")
    public Flight updateFlight(@RequestParam(value="f_id",required = true) String f_id,@RequestParam(value="dest") String destination,@RequestParam(value="origin") String origin){
        return this.service.updateFlight(Integer.parseInt(f_id),destination,origin);
    }
    @DeleteMapping("/flights/{courseId}")
    public String deleteFlight(@PathVariable String courseId){
        return this.service.deleteFlightById(Integer.parseInt(courseId));
    }
    @GetMapping("/flights/passenger/{passId}")
    public List<Flight> flightByPassenger(@PathVariable String passId){
        return this.service.getPassengerFLights(Integer.parseInt(passId));
    }
    @PostMapping("/passenger")
    public Passenger addPassenger(@RequestBody Passenger p){
        return this.service.addPassenger(p);

    }
    @PutMapping("/addPass/{flightId}/{p_id}")
    public String addPassengerToFlight(@PathVariable String flightId,@PathVariable String p_id){
        return this.service.addPassengerToFlight(Integer.parseInt(p_id),Integer.parseInt(flightId));
    }
    @PutMapping("/removePass/{flightId}/{p_id}")
    public String removePassengerFromFlight(@PathVariable String flightId,@PathVariable String p_id){
        return this.service.removePassengerFromFlight(Integer.parseInt(p_id),Integer.parseInt(flightId));
    }
    @GetMapping("/passenger/{p_id}")
    public Passenger getPassengerById(@PathVariable String p_id){
        return this.service.getPassenger(Integer.parseInt(p_id));
    }
}
