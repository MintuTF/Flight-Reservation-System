package edu.miu.cs.flightreservation.repository;


import edu.miu.cs.flightreservation.model.Airport;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AirportRepository extends PagingAndSortingRepository<Airport, Long> {

}