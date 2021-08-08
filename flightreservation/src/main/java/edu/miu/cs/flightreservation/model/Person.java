package edu.miu.cs.flightreservation.model;


import lombok.Data;

@Data
public class Person {
    private long id;
    private String username;
    private String password;
    private  String status;
    private String firstName;
    private String lastName;
    private  String email;


    public Person(String username, String password, String status, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
