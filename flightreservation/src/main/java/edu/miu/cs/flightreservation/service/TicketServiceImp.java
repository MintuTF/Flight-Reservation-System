package edu.miu.cs.flightreservation.service;


import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.model.Ticket;
import edu.miu.cs.flightreservation.repository.PersonRepository;
import edu.miu.cs.flightreservation.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImp implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> getTicket(long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

/*
   @Override
    public Person createTicket(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getOnePersonByUsername(String username) {
        return personRepository.findPersonByUsername(username);
    }

    @Override
    public void deletePerson(Person person) {

       personRepository.delete(person);

    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> getOnePersonById(Long id) {
        return personRepository.findById(id);

    }*/
}
