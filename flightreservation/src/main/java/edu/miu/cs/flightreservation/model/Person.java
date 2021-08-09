package edu.miu.cs.flightreservation.model;


import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor


public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private  String status;
    private String firstName;
    private String lastName;
    private  String email;

    @ManyToMany(mappedBy = "people")
    private Set<Role> roles;
    //@Embedded
   // private Address address;

    public Person(String username, String password,
                  String status, String firstName,
                  String lastName, String email,Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles=roles;

    }

//    public boolean addRoles(Role role){
//        boolean status=false;
//        if (roles.add(role)){
//            role.addOnePeson(this);
//            status=true;
//        }
//        return status;
//    }
//
//    public boolean addOneRole(Role role){
//     return this.roles.add(role);
//    }

}
