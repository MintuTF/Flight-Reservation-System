package edu.miu.cs.flightreservation.model;


import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "Person")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private  String status;
    private String firstName;
    private String lastName;
    private  String email;
    @ManyToMany
    private Set<Role> roles;
    @Embedded
    private Address address;


    public boolean addRoles(Role role){
        boolean status=false;
        if (roles.add(role)){
            role.addOnePeson(this);
            status=true;
        }
        return status;
    }

    public boolean addOneRole(Role role){
     return this.roles.add(role);
    }

}
