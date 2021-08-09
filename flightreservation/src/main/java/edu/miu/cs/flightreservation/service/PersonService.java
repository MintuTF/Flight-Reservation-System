package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.Util.payload.SignupRequest;
import edu.miu.cs.flightreservation.model.Person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface PersonService {

       Person createPerson(Person person);
       Page<Person> getAllPerson(Pageable pageable);
       Person getOnePersonByUsername(String username);
       void  deletePerson(Long id);
       Person updatePerson(Long id, SignupRequest signupRequest);
       Person getOnePersonById(Long id);



}
