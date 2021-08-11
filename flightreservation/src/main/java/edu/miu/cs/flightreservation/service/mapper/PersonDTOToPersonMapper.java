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
public class PersonDTOToPersonMapper extends BaseMapper<PersonDTO, Person> {
    @Autowired
    public PersonDTOToPersonMapper(MapperFactory mapperFactory) {
        super(mapperFactory, PersonDTO.class, Person.class);
    }
}
