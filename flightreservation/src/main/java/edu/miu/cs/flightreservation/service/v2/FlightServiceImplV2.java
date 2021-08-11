package edu.miu.cs.flightreservation.service.v2;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.model.Flight;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightServiceImplV2 extends BaseReadWriteServiceImpl<FlightDTO, Flight, Long> implements FlightService {
}
