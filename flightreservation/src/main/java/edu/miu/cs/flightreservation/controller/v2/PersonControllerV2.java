package edu.miu.cs.flightreservation.controller.v2;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.flightreservation.dto.PersonDTO;
import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.service.v2.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/persons")
public class PersonControllerV2 extends BaseReadWriteController<PersonDTO, Person, Long> {
    @Autowired
    private PersonService personService;
}
