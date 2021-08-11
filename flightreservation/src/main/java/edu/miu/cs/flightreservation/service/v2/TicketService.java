package edu.miu.cs.flightreservation.service.v2;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.flightreservation.dto.ReservationDTO;
import edu.miu.cs.flightreservation.dto.TicketDTO;
import edu.miu.cs.flightreservation.model.Reservation;
import edu.miu.cs.flightreservation.model.Ticket;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public interface TicketService extends BaseReadWriteService<TicketDTO, Ticket, Long> {
}
