package edu.miu.cs.flightreservation.service.v2;


import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.flightreservation.dto.PersonDTO;
import edu.miu.cs.flightreservation.dto.ReservationDTO;
import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService extends BaseReadWriteService<ReservationDTO, Reservation, Long> {
}