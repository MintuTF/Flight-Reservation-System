package edu.miu.cs.flightreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.miu.common", "edu.miu.cs"})
public class FlightreservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}

}
