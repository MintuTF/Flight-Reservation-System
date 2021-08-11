package edu.miu.cs.flightreservation.service.v2;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.flightreservation.dto.ReservationDTO;
import edu.miu.cs.flightreservation.model.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImplV2 extends BaseReadWriteServiceImpl<ReservationDTO, Reservation, Long> implements ReservationService {
}