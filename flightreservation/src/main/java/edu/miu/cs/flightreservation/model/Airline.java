package edu.miu.cs.flightreservation.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
public class Airline {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @SecondaryTable(name="airlinehistories")
    private String history;
}
