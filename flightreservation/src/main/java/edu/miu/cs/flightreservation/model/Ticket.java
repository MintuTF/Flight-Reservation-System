package edu.miu.cs.flightreservation.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
public class Ticket {
    private long id;
    private int number;
    private String reservationCode;
    private  LocalDate date;



    public Ticket(int num, String code, LocalDate d) {
        this.number = username;
        this.reservationCode = code;
        this.date = d;

    }
}
