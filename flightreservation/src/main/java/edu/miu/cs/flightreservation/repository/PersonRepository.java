package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findPersonByUsername(String username);
    Person findPersonById(Long id);

}
