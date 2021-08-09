package edu.miu.cs.flightreservation.service;


import edu.miu.cs.flightreservation.Util.payload.SignupRequest;
import edu.miu.cs.flightreservation.model.Address;
import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.model.Role;
import edu.miu.cs.flightreservation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Embedded;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRoleService userRoleService;


   @Override
    public Person createPerson(SignupRequest signupRequest) {
       System.out.println(signupRequest);
   Person person1=new Person(signupRequest.getUsername(),
           signupRequest.getPassword(),
           signupRequest.getStatus(), signupRequest.getFirstName(),
           signupRequest.getLastName(), signupRequest.getEmail(),
           userRoleService.userRole(signupRequest));
        return personRepository.save(person1);
    }

    @Override
    public Page<Person> getAllPerson(Pageable pageable ) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Person getOnePersonByUsername(String username) {
        return personRepository.findPersonByUsername(username);
    }

    @Override
    public void deletePerson(Long id) {
     Person person=personRepository.findPersonById(id);
       personRepository.delete(person);

    }

    @Override
    public Person updatePerson(Long id, SignupRequest signupRequest) {


       Person person1=personRepository.findPersonById(id);
       person1.setFirstName(signupRequest.getFirstName());
       person1.setLastName(signupRequest.getLastName());
       //person1.setAddress(signupRequest.getAddress());
       person1.setUsername(signupRequest.getUsername());
       person1.setStatus("Active");
       //person1.setRoles(userRoleService.userRole(signupRequest));


       return personRepository.save(person1);

    }

    @Override
    public Person getOnePersonById(Long id) {

       return personRepository.findPersonById(id);
    }
}
