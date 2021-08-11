package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.Util.payload.request.FlightRequest;
import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.service.AirlineServiceImpl;
import edu.miu.cs.flightreservation.service.AirportServiceImpl;
import edu.miu.cs.flightreservation.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/flights")
public class FlightController {
    @Autowired
    private FlightServiceImpl flightService;

    @Autowired
    private AirportServiceImpl airportService;

    @Autowired
    private AirlineServiceImpl airlineService;

    @GetMapping()
    public ResponseEntity<List<Flight>> getFlightsByPage(){
        List<Flight> flights = flightService.findAll();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping(params = "page=true")
    public ResponseEntity<Page<Flight>> getFlightsByPage(Pageable pageable){
        Page<Flight> Flights = flightService.findAll(pageable);
        return new ResponseEntity<>(Flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") Long id){
        Flight flight = flightService.findById(id);
        if(flight != null){
            return new ResponseEntity<>(flight, HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

//    @PostMapping()
//    public ResponseEntity<Flight> createFlight(@RequestBody FlightRequest flight){
//        try{
//            Flight _flight = new Flight();
//            Airport originAirport = airportService.findById(flight.getOriginAirport());
//            Airport destinationAirport = airportService.findById(flight.getDestinationAirport());
//            Airline airline = airlineService.findById(flight.getAirlineId());
//
//            if(originAirport == null || destinationAirport == null || airline == null)
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            _flight.setOriginAirport(originAirport);
//            _flight.setDestinationAirport(destinationAirport);
//            _flight.setAirLine(airline);
//            return new ResponseEntity(flightService.create(_flight), HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable("id") Long id, @RequestBody @Valid FlightRequest flight){
        Flight _flight = flightService.findById(id);
        if(flight != null){
            Airport originAirport = airportService.findById(flight.getOriginAirport());
            Airport destinationAirport = airportService.findById(flight.getDestinationAirport());
            Airline airline = airlineService.findById(flight.getAirlineId());
            if(originAirport == null || destinationAirport == null || airline == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            _flight.setOriginAirport(originAirport);
            _flight.setDestinationAirport(destinationAirport);
            _flight.setAirLine(airline);
            return new ResponseEntity<>(flightService.update(_flight), HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFlight(@PathVariable("id") Long id){
        Flight flight = flightService.findById(id);
        if(flight != null){
            flightService.delete(flight);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Flight>> getFlightsByDepartureDestinationDate(@RequestParam("departure") String departure,
                                                                             @RequestParam("arrival") String arrival,
                                                                             @RequestParam("date") String date){
        Airport departureAirport = airportService.findByCode(departure);
        Airport arrivalAirport = airportService.findByCode(arrival);
        if(departureAirport==null || arrivalAirport == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        System.out.println("my dTETIME:"+dateTime);

        List<Flight>flights = flightService.findFlightByDepartureDestinationAirportForDate(departureAirport,arrivalAirport,dateTime);
        return new ResponseEntity<>(flights, HttpStatus.OK);

    }
}
