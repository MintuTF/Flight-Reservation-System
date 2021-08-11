package edu.miu.cs.flightreservation.repository;


import edu.miu.cs.flightreservation.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface AirportRepository extends JpaRepository<Airport, Long> {

    @Query("FROM Airport airport WHERE airport.code=:code")
    Optional<Airport> findByCode(@Param("code") String code);

}