package edu.miu.cs.flightreservation.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private ERole name;
    @ManyToMany
    private List<Person> people;
    public Role(ERole name) {
        this.name = name;
    }

    public boolean addPerson(Person person){
        boolean status=false;
        if (people.add(person)){
            person.addOneRole(this);
            status=true;
        }
        return status;
    }

    public boolean addOnePeson(Person person){
        return  people.add(person);
    }
}
