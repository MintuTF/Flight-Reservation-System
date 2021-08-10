package edu.miu.cs.flightreservation.Util.payload.request;


import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class AirlineRequest {
    @NotBlank
    @Size(min = 1)
    private String name;
    @NotBlank
    @Size(min = 1)
    private String history;
}
