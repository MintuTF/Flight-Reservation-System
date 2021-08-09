package edu.miu.cs.flightreservation.model;


import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

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




}
