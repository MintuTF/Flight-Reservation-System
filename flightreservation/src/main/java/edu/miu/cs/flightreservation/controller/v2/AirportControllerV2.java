package edu.miu.cs.flightreservation.controller.v2;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.flightreservation.dto.AirportDTO;
import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.service.v2.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/airports")
public class AirportControllerV2 extends BaseReadWriteController<AirportDTO, Airport, Long> {
    @Autowired
    private AirportService airportService;
}
