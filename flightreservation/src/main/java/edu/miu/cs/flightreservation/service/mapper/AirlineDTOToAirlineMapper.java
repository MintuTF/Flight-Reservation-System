package edu.miu.cs.flightreservation.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.flightreservation.dto.AirlineDTO;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.model.Airline;
import edu.miu.cs.flightreservation.model.Flight;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirlineDTOToAirlineMapper extends BaseMapper<AirlineDTO, Airline> {
    @Autowired
    public AirlineDTOToAirlineMapper(MapperFactory mapperFactory) {
        super(mapperFactory, AirlineDTO.class, Airline.class);
    }
}
