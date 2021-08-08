package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Airport;

import java.util.List;

public interface AirportService {
    public Airport save(Airport airport);
    public List<Airport> findAll();
    public Airport findById(Long id);
    public void delete(Airport airport);
    public void deleteById(Long id);
}
