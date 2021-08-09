package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.model.Reservation;
import edu.miu.cs.flightreservation.model.ReservationRequest;
import edu.miu.cs.flightreservation.service.AddressServiceImpl;
import edu.miu.cs.flightreservation.service.FlightServiceImpl;
import edu.miu.cs.flightreservation.service.ReservationServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @Autowired
    private FlightServiceImpl flightService;

    @GetMapping()
    public ResponseEntity<List<Reservation>> getReservationsByPage(){
        List<Reservation> reservations = reservationService.findAll();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(params = "page=true")
    public ResponseEntity<Page<Reservation>> getReservationsByPage(Pageable pageable){
        Page<Reservation> reservations = reservationService.findAll(pageable);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Reservation> createReservation(@RequestBody @Valid ReservationRequest reservation){
        long[] flights = reservation.getFlights();


        try{
            Reservation _reservation = new Reservation();
            _reservation.generateCode();

            return new ResponseEntity(reservationService.save(_reservation), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id){
        Reservation _reservation = reservationService.findById(id);
        if(_reservation != null){
            return new ResponseEntity<>(_reservation, HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation){
        Reservation _reservation = reservationService.findById(id);
        if(_reservation != null){
                return new ResponseEntity<>(reservationService.save(_reservation), HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReservation(@PathVariable("id") Long id){
        Reservation _reservation = reservationService.findById(id);
        if(_reservation != null){
            reservationService.delete(_reservation);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
