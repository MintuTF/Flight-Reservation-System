package edu.miu.cs.flightreservation.model;

import edu.miu.cs.flightreservation.service.UtilService;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String number;
    private int capacity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airline airLine;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airport originAirport;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airport destinationAirport;

    public Flight(){
        this.number = UtilService.generateAlphanumeric(UtilService.DEFAULT_LENGTH);
    }
}