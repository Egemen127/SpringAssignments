package org.genspark.Entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Passenger implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int p_id;
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "Flight",
            joinColumns = {@JoinColumn(name = "p_id")},
            inverseJoinColumns = {@JoinColumn(name = "f_id")}
    )
    //@JsonBackReference
    @JsonIgnoreProperties({"p_list"})
    private Set<Flight> flights= new HashSet<Flight>();
    public Passenger(){

    }
    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }
    public Set<Flight> getFlights() {
        return flights;
    }
    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void addFlight(Flight f){this.flights.add(f);}
    public void removeFlight(Flight f){this.flights.remove(f);}

    @Override
    public String toString() {
        return "Passenger{" +
                "p_id=" + p_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", flights=" + flights +
                '}';
    }
}
