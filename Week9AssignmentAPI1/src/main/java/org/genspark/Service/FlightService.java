package org.genspark.Service;

import org.genspark.Entity.Flight;
import org.genspark.Entity.Passenger;

import java.util.List;

public interface FlightService {
    List<Flight> getAllFlights();
    Flight getFlightById(int flightId);
    List<Flight> getPassengerFLights(int passId);
    Flight addFlight(Flight flight);
    Flight updateFlight(int f_id,String destination,String origin);
    String deleteFlightById(int id);
    Passenger addPassenger(Passenger pass);
    Passenger getPassenger(int id);
    String addPassengerToFlight(int p_id,int f_id);
    String removePassengerFromFlight(int p_id,int f_id);
}
