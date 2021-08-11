package edu.miu.cs.flightreservation.repository.v2;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.model.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TicketRepositoryV2 extends BaseRepository<Ticket, Long> {
}