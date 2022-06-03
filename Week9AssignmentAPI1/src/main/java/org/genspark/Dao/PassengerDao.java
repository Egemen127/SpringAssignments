package org.genspark.Dao;

import org.genspark.Entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDao extends JpaRepository<Passenger,Integer> {
}
