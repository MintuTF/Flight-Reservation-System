package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Person;

public interface PersonService {

    public Person createPerson(Person person);

    public Person getPerson();
}
