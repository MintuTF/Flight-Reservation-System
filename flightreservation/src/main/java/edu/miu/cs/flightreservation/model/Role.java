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
    private long id;
    @Enumerated(EnumType.STRING)
    private ERole name;
    @ManyToMany
    @JoinTable(name="person_role",
            joinColumns = @JoinColumn(name="role_id"),
            inverseJoinColumns = @JoinColumn(name="person_id"))
    private List<Person> people;


    public Role (ERole name){
        this.name=name;
    }


//    public boolean addPerson(Person person){
//        boolean status=false;
//        if (people.add(person)){
//            person.addOneRole(this);
//            status=true;
//        }
//        return status;
//    }

    public boolean addOnePeson(Person person){
        return  people.add(person);
    }
}
