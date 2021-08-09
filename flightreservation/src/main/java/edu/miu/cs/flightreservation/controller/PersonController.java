package edu.miu.cs.flightreservation.controller;

import edu.miu.cs.flightreservation.model.Person;
import edu.miu.cs.flightreservation.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/persons")
public class PersonController {

    @Autowired
    private PersonServiceImp personServiceImp;

    @GetMapping ("/{id}")
    public ResponseEntity<?> getOnePerson(@PathVariable Long id){

        ResponseEntity<?> responseEntity=null;
        try {

            Person getUser = personServiceImp.getOnePersonById(id);
            if (getUser != null) {

                responseEntity=new ResponseEntity<>(getUser, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }


    @PostMapping("signup")
    public ResponseEntity<?> createPerson(@RequestBody Person person){

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@RequestBody Long id){

        ResponseEntity<?> responseEntity=null;
        try {

            personServiceImp.deletePerson(id);

        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }

    @GetMapping(params = "paged=true")
    public ResponseEntity<?> findAllPersons(Pageable page) {

        ResponseEntity<?> responseEntity=null;
        try {

            personServiceImp.getAllPerson(page);

        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id,@RequestBody Person person){

        ResponseEntity<?> responseEntity=null;
        try {

            Person getUser = personServiceImp.updatePerson(person);
            if (getUser != null) {

                responseEntity=new ResponseEntity<>(getUser, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseEntity =new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }
}
