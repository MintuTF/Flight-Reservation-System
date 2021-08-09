package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findPersonByUsername(String username);

}
