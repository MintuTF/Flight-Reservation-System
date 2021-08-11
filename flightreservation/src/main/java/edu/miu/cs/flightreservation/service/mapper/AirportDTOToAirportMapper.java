package edu.miu.cs.flightreservation.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.flightreservation.dto.AirportDTO;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.model.Flight;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirportDTOToAirportMapper extends BaseMapper<AirportDTO, Airport> {
    @Autowired
    public AirportDTOToAirportMapper(MapperFactory mapperFactory) {
        super(mapperFactory, AirportDTO.class, Airport.class);
    }
}
