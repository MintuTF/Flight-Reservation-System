package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Airport;
import edu.miu.cs.flightreservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("FROM Reservation reservation WHERE reservation.reservationCode=:code")
    Optional<Reservation> findByCode(@Param("code") String code);

    @Query("FROM Reservation reservation WHERE reservation.id=:passengerId")
    List<Reservation> findByPassenger(@Param("passengerId") String passengerId);

    @Query("FROM Reservation reservation WHERE reservation.id=:createdById")
    List<Reservation> findByCreatedBy(@Param("createdById") String createdById);

    @Query("FROM Reservation reservation WHERE " +
            "reservation.passenger.id=:personId " +
            "OR reservation.createdBy.id=:personId")
    List<Reservation> findAllByPersonId(@Param("personId") Long personId);

}