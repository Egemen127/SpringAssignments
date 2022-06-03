package org.genspark.Entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tbl_flight")
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int f_id;
    private String destination;
    private String origin;
    @ManyToMany(mappedBy = "flights",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    //@JsonManagedReference
    @JsonIgnoreProperties({"flights"})
    private Set<Passenger> p_list= new HashSet<Passenger>();
    public Flight(){

    }
    public Flight(String destination, String origin) {
        this.destination = destination;
        this.origin = origin;
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Set<Passenger> getP_list() {
        return p_list;
    }

    public void setP_list(Set<Passenger> p_list) {
        this.p_list = p_list;
    }

    public void addPassenger(Passenger p){this.p_list.add(p);}
    public void removePassenger(Passenger p){this.p_list.remove(p);}

    @Override
    public String toString() {
        return "Flight{" +
                "f_id=" + f_id +
                ", destination='" + destination + '\'' +
                ", origin='" + origin + '\'' +
                ", p_list=" + p_list +
                '}';
    }
}
