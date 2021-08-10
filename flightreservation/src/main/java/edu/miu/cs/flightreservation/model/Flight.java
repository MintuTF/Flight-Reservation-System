package edu.miu.cs.flightreservation.model;

import edu.miu.cs.flightreservation.service.UtilService;
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
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    @OneToMany(mappedBy = "flight")
    @JoinColumn
    private List<Ticket> tickets;
    @ManyToOne
    private Airline airLine;
    @ManyToOne
    private Airport originAirport;
    @ManyToOne
    private Airport destinationAirport;

    public Flight(){
        this.number = UtilService.generateAlphanumeric(UtilService.DEFAULT_LENGTH);
    }
}