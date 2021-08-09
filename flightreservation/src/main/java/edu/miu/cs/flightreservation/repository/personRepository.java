package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface personRepository extends JpaRepository<Person,Long> {

}
