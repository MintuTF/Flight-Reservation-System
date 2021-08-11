package edu.miu.cs.flightreservation.Util.payload.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightRequest {
    private long capacity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private long airlineId;
    private long originAirport;
    private long destinationAirport;
}