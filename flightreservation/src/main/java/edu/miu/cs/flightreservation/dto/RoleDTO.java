package edu.miu.cs.flightreservation.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private ERole name;
    private List<PersonDTO> people=new ArrayList<>();

}
