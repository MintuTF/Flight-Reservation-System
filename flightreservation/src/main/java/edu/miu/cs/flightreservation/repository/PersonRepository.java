package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findPersonByUsername(String username);
    Person findPersonById(Long id);
    @Query("FROM Person WHERE email=:email")
    Optional<Person> findPersonByEmail(@Param("email") String email);

}