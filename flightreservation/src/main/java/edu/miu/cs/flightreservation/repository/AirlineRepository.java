package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    //select all the airlines where the airlines in the flights
    @Query("SELECT airline FROM" +
            " Airline airline join airline.flights flight  where flight.originAirport.code=:code")
    List<Airline> findAirlinesByAirportCode(@Param("code") String code);

}