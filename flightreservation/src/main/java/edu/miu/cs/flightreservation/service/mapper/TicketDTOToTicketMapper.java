package edu.miu.cs.flightreservation.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.flightreservation.dto.PersonDTO;
import edu.miu.cs.flightreservation.dto.TicketDTO;
import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.model.Ticket;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketDTOToTicketMapper extends BaseMapper<TicketDTO, Ticket> {
    @Autowired
    public TicketDTOToTicketMapper(MapperFactory mapperFactory) {
        super(mapperFactory, TicketDTO.class, Ticket.class);
    }
}
