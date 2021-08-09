package edu.miu.cs.flightreservation.model;

import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight {
    private long id;
    private String number;
    private int capacity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    @ManyToOne
    private Airline airline;
    @ManyToOne
    private Airport destinationAirport;
    @ManyToOne
    private Airport originAirport;

}
