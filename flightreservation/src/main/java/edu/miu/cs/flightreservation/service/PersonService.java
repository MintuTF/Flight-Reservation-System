package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface PersonService {

       Person createPerson(Person person);
       List<Person> getAllPerson();
       Person getOnePersonByUsername(String username);
       void  deletePerson(Person person);
       Person updatePerson(Person person);
       Optional<Person> getOnePersonById(Long id);



}
