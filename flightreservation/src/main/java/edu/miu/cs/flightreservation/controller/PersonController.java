package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    private PersonServiceImp personServiceImp;

    @PostMapping("signup")
    public ResponseEntity<?> signupPerson(@RequestBody Person person){

        ResponseEntity<?> responseEntity=null;
        try {

             Person getUser = personServiceImp.createPerson(person);
            if (getUser != null) {

                responseEntity=new ResponseEntity<>(getUser, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }


}
