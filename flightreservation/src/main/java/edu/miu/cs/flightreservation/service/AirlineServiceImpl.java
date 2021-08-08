package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline findById(Long id) {
        return airlineRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Airline airline) {
        airlineRepository.delete(airline);
    }

    @Override
    public void deleteById(Long id) {
        airlineRepository.deleteById(id);
    }

    @Override
    public Airline save(Airline airline) {
        return airlineRepository.save(airline);
    }
}
