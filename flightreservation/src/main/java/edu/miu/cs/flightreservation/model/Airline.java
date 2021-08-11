package edu.miu.cs.flightreservation.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@SecondaryTable(name = "airlinehistories")
public class Airline {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "airLine")
    private List<Flight> flights = new ArrayList<Flight>();

    @Column(table="airlinehistories")

    private String history;
}
