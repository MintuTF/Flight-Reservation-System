package edu.miu.cs.flightreservation.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@embaddable
@Entity
public class Address {
    @Id
    @GeneratedValue
    private long id;
    private String street;
    private String city;
    private String state;
    private String zip;
}
