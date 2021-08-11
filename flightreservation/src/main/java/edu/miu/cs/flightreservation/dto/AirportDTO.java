package edu.miu.cs.flightreservation.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class AirportDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
}
