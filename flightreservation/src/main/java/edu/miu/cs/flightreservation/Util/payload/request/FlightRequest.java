package edu.miu.cs.flightreservation.Util.payload.request;

import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.model.Ticket;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightRequest {
    private long capacity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private long airlineId;
    private long originAirport;
    private long destinationAirport;
}