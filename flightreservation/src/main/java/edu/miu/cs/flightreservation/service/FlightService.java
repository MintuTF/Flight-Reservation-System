package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.model.Flight;

import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    public List<Flight> findAll();

    public Flight findById(long id);
    public Page<Flight> findAll(Pageable pageable);
    public Flight update(Flight flight);
    boolean exists(long[] flights);
    public void delete(Flight flight);
    public List<Flight> findFlightsByDepartureAndArrivalDate(LocalDateTime departureDate, LocalDateTime arrivalDate);
    List<Flight> findFlightByDepartureDestinationAirportForDate(Airport departureAirport,Airport arrivalAirport, LocalDateTime departureDate);



}
