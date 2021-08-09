package edu.miu.cs.flightreservation.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

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
