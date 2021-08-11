package edu.miu.cs.flightreservation.service.v2;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.flightreservation.dto.AirlineDTO;
import edu.miu.cs.flightreservation.model.Airline;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AirlineServiceImplV2 extends BaseReadWriteServiceImpl<AirlineDTO, Airline, Long>  implements AirlineService {
}
