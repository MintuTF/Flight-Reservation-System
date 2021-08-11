package edu.miu.cs.flightreservation.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.dto.PersonDTO;
import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.model.Person;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDTOMapper extends BaseMapper<Person, PersonDTO> {
    @Autowired
    public PersonToPersonDTOMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Person.class, PersonDTO.class);
    }
}
