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
public class AirportToAirportDTOMapper extends BaseMapper<Airport, AirportDTO> {
    @Autowired
    public AirportToAirportDTOMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Airport.class, AirportDTO.class);
    }
}
