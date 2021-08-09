package edu.miu.cs.flightreservation.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequest {
    private long person_id;
    private String firstName;
    private String lastName;
    private String departurePlace;
    private String arrivalPlace;
    private String email;
    private String gender;
    private String phoneNumber;
    private long passportId;
    private long[] flights;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
}
