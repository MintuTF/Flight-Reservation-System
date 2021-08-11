package edu.miu.cs.flightreservation.service.v2;


import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.flightreservation.dto.PersonDTO;
import edu.miu.cs.flightreservation.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpV2 extends BaseReadWriteServiceImpl<PersonDTO, Person, Long> implements PersonService {
}
