package edu.miu.cs.flightreservation.service.v2;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.flightreservation.dto.AirportDTO;
import edu.miu.cs.flightreservation.model.Airport;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AirportServiceImplV2 extends BaseReadWriteServiceImpl<AirportDTO, Airport, Long>  implements AirportService {
}
