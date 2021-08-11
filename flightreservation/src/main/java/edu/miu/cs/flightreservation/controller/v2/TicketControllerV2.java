package edu.miu.cs.flightreservation.controller.v2;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.flightreservation.dto.TicketDTO;
import edu.miu.cs.flightreservation.model.Ticket;
import edu.miu.cs.flightreservation.service.v2.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/tickets")
public class TicketControllerV2 extends BaseReadWriteController<TicketDTO, Ticket, Long> {
    @Autowired
    private TicketService ticketService;
}
