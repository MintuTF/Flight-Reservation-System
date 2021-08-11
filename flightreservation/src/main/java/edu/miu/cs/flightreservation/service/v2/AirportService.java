package edu.miu.cs.flightreservation.service.v2;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.flightreservation.dto.AirlineDTO;
import edu.miu.cs.flightreservation.dto.AirportDTO;
import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AirportService extends BaseReadWriteService<AirportDTO, Airport, Long> {
}
