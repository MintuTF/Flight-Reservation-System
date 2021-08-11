package edu.miu.cs.flightreservation.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Airport implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Column(length=3, nullable=false)
    private String code;

    @Embedded
    private Address address;
}
