package edu.miu.cs.flightreservation.service.v2;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.flightreservation.dto.AirlineDTO;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AirlineService extends BaseReadWriteService<AirlineDTO, Airline, Long> {
}
