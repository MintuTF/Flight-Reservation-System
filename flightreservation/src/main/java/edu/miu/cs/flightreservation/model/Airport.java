package edu.miu.cs.flightreservation.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
public class Airport {
    @Id
    @GeneratedValue
    private long id;
    private String name;
}
