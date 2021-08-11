package edu.miu.cs.flightreservation.service.v2;


import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.flightreservation.dto.TicketDTO;
import edu.miu.cs.flightreservation.model.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpV2 extends BaseReadWriteServiceImpl<TicketDTO, Ticket, Long>  implements TicketService {
}
