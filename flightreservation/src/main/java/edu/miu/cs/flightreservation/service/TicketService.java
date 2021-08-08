package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.*;

public interface TicketService {

    public Ticket createTicket(Ticket ticket);

    public Ticket getTicket();
}
