package edu.miu.cs.flightreservation.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.model.Flight;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightToFLightDTOMapper extends BaseMapper<Flight, FlightDTO> {
    @Autowired
    public FlightToFLightDTOMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Flight.class, FlightDTO.class);
    }
}
