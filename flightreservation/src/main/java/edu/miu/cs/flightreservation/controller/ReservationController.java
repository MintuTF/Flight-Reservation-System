package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.Util.payload.request.ReservationRequest;
import edu.miu.cs.flightreservation.Util.payload.request.ReservationStatusRequest;
import edu.miu.cs.flightreservation.Util.security.jwt.JwtUtils;
import edu.miu.cs.flightreservation.model.*;
import edu.miu.cs.flightreservation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @Autowired
    private FlightServiceImpl flightService;

    @Autowired
    private PersonServiceImp personService;

    @Autowired
    private TicketServiceImp ticketService;

    @GetMapping()
    public ResponseEntity<List<Reservation>> getReservationsByPage(HttpServletRequest httpServletRequest){
        Person auth = personService.getPersonFromToken(httpServletRequest);
        List<Reservation> reservations = new ArrayList<Reservation>();
        if(auth != null){
            reservations = reservationService.findAllByPersonId(auth.getId());
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        }
        return new ResponseEntity<>(reservations, HttpStatus.NO_CONTENT);
    }

    //TODO this must not  be availlable for passenger
    @GetMapping(params = "page=true")
    public ResponseEntity<Page<Reservation>> getReservationsByPage(Pageable pageable){
        Page<Reservation> reservations = reservationService.findAll(pageable);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    //TODO ROLE BASED AUTHORIZATION
    @PostMapping()
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ResponseEntity<Reservation> createReservation(HttpServletRequest httpServletRequest,
                                                         @RequestBody @Valid ReservationRequest reservation){
        Person auth = personService.getPersonFromToken(httpServletRequest);
        try{
            long[] flights = reservation.getFlights();
            if(!flightService.exists(flights))
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            //TODO Discuss about it we need to check if the user exist we must just get the passenger_id
            Person person = new Person();
            person.setFirstName(reservation.getFirstName());
            person.setLastName(reservation.getLastName());
            person.setEmail(reservation.getEmail());
            person.setPassportId(reservation.getPassportId());
            person.setPhoneNumber(reservation.getPhoneNumber());
            person.setGender(reservation.getGender());
            //TODO generate the encrypted password
            person.setPassword("password");
            Person _person = personService.save(person);
            Reservation _reservation = new Reservation();
            _reservation.setDepartureDate(reservation.getDepartureDate());
            _reservation.setCreatedBy(auth);
            _reservation.setPassenger(_person);
            _reservation.setArrivalDate(reservation.getArrivalDate());
            _reservation.setDepartureDate(reservation.getDepartureDate());
            _reservation.setArrivalPlace(reservation.getArrivalPlace());
            _reservation.setDepartureDeparture(reservation.getDeparturePlace());
            reservationService.updateStatus(_reservation, reservation.getStatus());
            reservationService.save(_reservation);

            int i; int j;

            for(i=0;  i<reservation.getTotalPerson(); i++){
                for(j=0; j<flights.length; j++) {
                    try{
                        Ticket _ticket = new Ticket();
                        //TODO uncomment
                        //_ticket.setFlight(flightService.findById(flights[j]));
                        _ticket.setFlight(null);
                        _ticket.setReservation(_reservation);
                        //TODO uncomment
                        //_ticket.setDate(_ticket.getFlight().getDepartureTime());
                        ticketService.createTicket(_ticket);
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
            }
            return new ResponseEntity(_reservation, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id){
        Reservation _reservation = reservationService.findById(id);
        if(_reservation != null){
            return new ResponseEntity<>(_reservation, HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservationStatus(HttpServletRequest httpServletRequest,
                                                               @PathVariable("id") Long id,
                                                               @RequestBody ReservationStatusRequest reservation){
        Person auth = personService.getPersonFromToken(httpServletRequest);
        Reservation _reservation = reservationService.findById(id);
        if(_reservation != null){
            if(!_reservation.getCreatedBy().equals(auth) && !_reservation.getPassenger().equals(auth))
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            reservationService.updateStatus(_reservation, reservation.getStatus());
                return new ResponseEntity<>(reservationService.save(_reservation), HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //TODO ROLE BASED AUTHORIZATION PASSENGER CAN DO THIS
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReservation(HttpServletRequest httpServletRequest, @PathVariable("id") Long id){
        Person auth = personService.getPersonFromToken(httpServletRequest);
        Reservation _reservation = reservationService.findById(id);
        if(_reservation != null){
            if(_reservation.getPassenger().equals(auth))
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            reservationService.delete(_reservation);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("code") String code){
        Reservation _reservation = reservationService.findByCode(code);
        if(_reservation != null){
            return new ResponseEntity<>(_reservation, HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
