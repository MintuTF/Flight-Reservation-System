package edu.miu.cs.flightreservation.dto;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TicketDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private int number;
    private String reservationCode;
    private LocalDate date;
}
