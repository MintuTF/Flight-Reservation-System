package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("FROM Flight Where departureTime=:departureDate AND arrivalTime=:arrivalDate")
    List<Flight> findFlightsByDepartureAndArrivalDate(@Param("departureDate") LocalDateTime departureDate,
                                                      @Param("arrivalDate") LocalDateTime arrivalDate);

    @Query("FROM Flight Where originAirport=:departureAirport " +
            " AND destinationAirport=:arrivalAirport" +
            " AND departureTime =:departureDate ")
        List<Flight> findFlightByDepartureDestinationAirportForDate(@Param("departureAirport") Airport departureAirport,
                                                      @Param("arrivalAirport") Airport arrivalAirport, @Param ("departureDate") LocalDateTime departureDate);

}
