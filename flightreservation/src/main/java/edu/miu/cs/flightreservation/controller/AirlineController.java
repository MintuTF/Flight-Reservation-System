package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.Util.payload.request.AirlineRequest;
import edu.miu.cs.flightreservation.model.Address;
import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.service.AirlineServiceImpl;
import edu.miu.cs.flightreservation.service.AirportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {
    @Autowired
    private AirlineServiceImpl airlineService;

    @Autowired
    private AirportServiceImpl airportService;

    @GetMapping()
    public ResponseEntity<List<Airline>> getAirlinesByPage(){
        List<Airline> airlines = airlineService.findAll();
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }

    @GetMapping(params = "page=true")
    public ResponseEntity<Page<Airline>> getAirlinesByPage(Pageable pageable){
        Page<Airline> airlines = airlineService.findAll(pageable);
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable("id") Long id){
        Airline _airline = airlineService.findById(id);
        if(_airline != null){
            return new ResponseEntity<>(_airline, HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<?> createAirline(@Valid @RequestBody  AirlineRequest airline){
        try{
            Airline _airline = new Airline();
            _airline.setHistory(airline.getHistory());
            _airline.setName(airline.getName());
            return new ResponseEntity(airlineService.save(_airline), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable("id") Long id, @RequestBody @Valid AirlineRequest airline){
        Airline _airline = airlineService.findById(id);
        if(airline != null){
                _airline.setName(airline.getName());
                _airline.setHistory(airline.getHistory());
                return new ResponseEntity<>(airlineService.save(_airline), HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAirline(@PathVariable("id") Long id){
        Airline _airline = airlineService.findById(id);
        if(_airline != null){
            airlineService.delete(_airline);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Airline>> getAirlinesByAirportCode(@RequestParam String airport){
        Airport _airport = airportService.findByCode(airport);
        System.err.println("CODE ======== "+ airport);
        System.err.println("Airport    ======= "+_airport);
        if(_airport != null) {
            List<Airline> airlines = airlineService.findAirlinesByAirportCode(_airport.getCode());
            if (airlines != null && !airlines.isEmpty())
                return new ResponseEntity<>(airlines, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
