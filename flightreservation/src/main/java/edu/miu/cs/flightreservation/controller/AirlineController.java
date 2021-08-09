package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.service.AirlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    private AirlineServiceImpl airlineService;

    @GetMapping()
    public Page<Airline> getAirlinesByPage(Pageable pageable){
        return airlineService.findAllByPage(pageable);
    }
}
