package edu.miu.cs.flightreservation.dto;

import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.model.Ticket;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String number;
    private int capacity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private List<Ticket> tickets;
    private Airline airLine;
    private Airport originAirport;
    private Airport destinationAirport;
}
