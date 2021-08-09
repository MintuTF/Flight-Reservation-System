package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.model.Ticket;
import edu.miu.cs.flightreservation.service.TicketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ticket")
public class TicketController {

    @Autowired
    private TicketServiceImp tikcetServiceInstance;

    @GetMapping()
    public ResponseEntity<List<Ticket>> findAll() {
        List <Ticket> t =  tikcetServiceInstance.getAllTicket();
                return new ResponseEntity<>(t,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket>  findById(@PathVariable(name = "id") Long ticketId) {
        Ticket t  = tikcetServiceInstance.getTicket(ticketId).get();
        return new ResponseEntity<>(t,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTicket(@PathVariable("id") Long id){
        Optional<Ticket> t = tikcetServiceInstance.getTicket(id) ;

        if(t.isPresent()){
            tikcetServiceInstance.deleteTicket(t.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping()
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {

            try{
                Ticket _ticket = new Ticket();
                return new ResponseEntity(tikcetServiceInstance.createTicket(_ticket), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }



    @PutMapping
    public ResponseEntity<Ticket> updateTicket(Ticket ticket){

        try{
            tikcetServiceInstance.getTicket(ticket.getId()).orElseThrow(RuntimeException::new);
        return new ResponseEntity(tikcetServiceInstance.createTicket(ticket), HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }





}
