package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Airline;

import java.util.List;

public interface AirlineService {
    public Airline save(Airline airline);
    public List<Airline> findAll();
    public Airline findById(Long id);
    public void delete(Airline airline);
    public void deleteById(Long id);
}
