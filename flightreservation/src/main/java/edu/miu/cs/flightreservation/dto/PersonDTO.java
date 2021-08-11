package edu.miu.cs.flightreservation.dto;


import edu.miu.cs.flightreservation.model.Address;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class PersonDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String username;
    private String password;
    private String status;
    private String firstName;
    private String lastName;
    private String email;
    private Set<RoleDTO> roles= new HashSet<>();
    private Address address;
}
