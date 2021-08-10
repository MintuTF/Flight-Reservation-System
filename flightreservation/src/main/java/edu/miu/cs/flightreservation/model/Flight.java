package edu.miu.cs.flightreservation.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private String number;
    private int capacity;
    private LocalDate departureTime;
    private LocalDateTime arrivalTime;
    @OneToMany(mappedBy = "flight")
    @JoinColumn
    @Transient
    private List<Ticket> tickets;
    @ManyToOne
    @Transient
    private Airline airLine;
    @ManyToOne
    @Transient
    private Airport originAirport;
    @ManyToOne
    @Transient
    private Airport destinationAirport;
}