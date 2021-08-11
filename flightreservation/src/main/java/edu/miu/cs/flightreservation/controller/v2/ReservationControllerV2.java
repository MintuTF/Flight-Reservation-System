package edu.miu.cs.flightreservation.controller.v2;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.service.v2.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/reservations")
public class ReservationControllerV2 extends BaseReadWriteController<FlightDTO, Flight, Long> {
    @Autowired
    private ReservationService reservationService;
}
