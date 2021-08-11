package edu.miu.cs.flightreservation.controller.v2;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.flightreservation.dto.AirlineDTO;
import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.service.v2.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/airlines")
public class AirlineControllerV2 extends BaseReadWriteController<AirlineDTO, Airline, Long> {
    @Autowired
    private AirlineService airlineService;
}
