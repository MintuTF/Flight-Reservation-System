package edu.miu.cs.flightreservation.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Data
@Entity
public class Airport {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Column(length=3, nullable=false)
    private String code;

    @Embedded
    private Address address;
}
