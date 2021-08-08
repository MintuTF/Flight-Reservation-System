package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport findById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Airport airport) {
        airportRepository.delete(airport);
    }

    @Override
    public void deleteById(Long id) {
        airportRepository.deleteById(id);
    }
}
