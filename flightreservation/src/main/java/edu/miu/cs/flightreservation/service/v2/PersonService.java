package edu.miu.cs.flightreservation.service.v2;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.flightreservation.Util.payload.request.SignupRequest;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.dto.PersonDTO;
import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface PersonService extends BaseReadWriteService<PersonDTO, Person, Long> {
}
