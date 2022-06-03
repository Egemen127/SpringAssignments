package org.genspark.Service;

import org.genspark.Dao.FlightDao;
import org.genspark.Dao.PassengerDao;
import org.genspark.Entity.Flight;
import org.genspark.Entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class FlightServiceImpl implements FlightService{
 @Autowired
 private FlightDao flightdao;
 @Autowired
 private PassengerDao passengerDao;
    @Override
    public List<Flight> getAllFlights() {
        return this.flightdao.findAll();
    }

    @Override
    public Flight getFlightById(int flightId) {
        Flight f0;
        Optional <Flight> f = this.flightdao.findById(flightId);
        if(f.isPresent()){
            f0 = f.get();
        } else
        { throw new RuntimeException("Flight not found for id :: "+flightId);}
        return f0;
    }
    @Override
    public List<Flight> getPassengerFLights(int passId) {

        ArrayList<Flight> result = new ArrayList<>();
        for(Flight f:getAllFlights()){
            for(Passenger p:f.getP_list()){
                if(p.getP_id()==passId){
                    result.add(f);
                }
            }
        }
        return result;
    }

    @Override
    public Flight addFlight(Flight flight) {
        return this.flightdao.save(flight);
    }

    @Override
    public Flight updateFlight(int f_id, String destination,String origin) {
        Flight f0 = this.flightdao.getReferenceById(f_id);
        f0.setDestination(destination);
        f0.setOrigin(origin);
        return this.flightdao.save(f0);
    }

    @Override
    public String deleteFlightById(int id) {
        Flight f0 = this.flightdao.getReferenceById(id);
        for(Passenger p:f0.getP_list())
            p.getFlights().remove(f0);
        f0.setP_list(null);
        this.flightdao.save(f0);
        System.out.println(this.flightdao.getReferenceById(id));
        this.flightdao.deleteById(id);
        return "Flight is Removed";
    }

    @Override
    public Passenger addPassenger(@RequestBody Passenger pass) {
        return this.passengerDao.save(pass);
    }

    @Override
    public Passenger getPassenger(int id) {
        Passenger p0;
        Optional <Passenger> p = this.passengerDao.findById(id);
        if(p.isPresent()){
            p0 = p.get();
        } else
        { throw new RuntimeException("Passenger not found for id :: "+id);}
        return p0;
    }

    @Override
    public String addPassengerToFlight(int p_id,int f_id) {
    Flight f0 = this.flightdao.getReferenceById(f_id);
    Passenger p = this.passengerDao.getReferenceById(p_id);
    f0.getP_list().add(p);
    p.getFlights().add(f0);
        this.passengerDao.save(p);
    return "Passenger added to the flight!";
    }

    @Override
    public String removePassengerFromFlight(int p_id,int f_id) {
        Flight f0 = this.flightdao.getReferenceById(f_id);
        Passenger p = this.passengerDao.getReferenceById(p_id);
        f0.getP_list().remove(p);
        p.getFlights().remove(f0);
        this.passengerDao.save(p);
        return "Passenger Removed from the Flight!!";
    }
}
