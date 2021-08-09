package edu.miu.cs.flightreservation.model;
import edu.miu.cs.flightreservation.service.UtilService;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private long id;
    private String reservationCode;
    private LocalDate reservationDate;
    private String departureDeparture;
    private String arrivalPlace;
    @ManyToOne
    private Person createdBy;
    @ManyToOne
    private Person passenger;
    @OneToMany
    private List <Ticket> tickets;
    private Status status;

    /*public Reservation(long id, String reservationCode, LocalDate reservationDate, String departureDeparture, String arrivalPlace, Person person, List<Ticket> tickets, Status status) {
        this.id = id;
        this.reservationCode = reservationCode;
        this.reservationDate = reservationDate;
        this.departureDeparture = departureDeparture;
        this.arrivalPlace = arrivalPlace;
        this.createdBy = createdBy;
        this.passenger= passenger;
        this.tickets = tickets;
        this.status = status;
    }*/

    public void Reservation() {
        this.reservationCode = UtilService.generateAlphanumeric(UtilService.DEFAULT_LENGTH);
    }

    public void update(Status status){
        this.status=status;
    }

    public void generateCode(){

    }
}