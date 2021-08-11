package edu.miu.cs.flightreservation.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class AirlineDTO implements Serializable {
    private static final long serialVersionUID = 1L;
//    private long id;
    private String name;
    private String history;
}
