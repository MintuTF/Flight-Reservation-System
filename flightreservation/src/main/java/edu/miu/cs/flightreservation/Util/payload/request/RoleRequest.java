package edu.miu.cs.flightreservation.Util.payload.request;

import edu.miu.cs.flightreservation.model.ERole;
import edu.miu.cs.flightreservation.model.Person;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



public class RoleRequest {

    private long id;
    private ERole name;
    private List<Person> people=new ArrayList<>();


}
