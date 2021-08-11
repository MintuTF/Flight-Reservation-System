package edu.miu.cs.flightreservation.service.v2;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.model.Flight;

public interface FlightService extends BaseReadWriteService<FlightDTO, Flight, Long> {
}
