package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FlightService {
    public List<Flight> findAll();
    public Page<Flight> findAll(Pageable pageable);
    public Flight findById(long id);
    public Flight update(Flight flight);
    public Flight create(Flight flight);
    public void delete(Flight flight);
}
