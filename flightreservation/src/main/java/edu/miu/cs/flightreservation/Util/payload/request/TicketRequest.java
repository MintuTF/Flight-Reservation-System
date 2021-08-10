package edu.miu.cs.flightreservation.Util.payload.request;


import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.model.Reservation;
import edu.miu.cs.flightreservation.service.UtilService;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data

public class TicketRequest {

    private long id;

    private String number;
    private LocalDate date;
    private long flightId;
    private long reservationId;

  




}
