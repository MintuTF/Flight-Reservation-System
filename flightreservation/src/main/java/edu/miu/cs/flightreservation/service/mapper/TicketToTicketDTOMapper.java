package edu.miu.cs.flightreservation.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.dto.TicketDTO;
import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.model.Ticket;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketToTicketDTOMapper extends BaseMapper<Ticket, TicketDTO> {
    @Autowired
    public TicketToTicketDTOMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Ticket.class, TicketDTO.class);
    }
}
