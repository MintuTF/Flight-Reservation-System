package edu.miu.cs.flightreservation.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
public class ReservationDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String reservationCode;
    private LocalDate reservationDate;
    private String departureDeparture;
    private String arrivalPlace;
}
