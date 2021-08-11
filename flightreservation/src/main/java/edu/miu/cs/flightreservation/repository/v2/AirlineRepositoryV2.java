package edu.miu.cs.flightreservation.repository.v2;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Flight;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AirlineRepositoryV2 extends BaseRepository<Airline, Long> {
}