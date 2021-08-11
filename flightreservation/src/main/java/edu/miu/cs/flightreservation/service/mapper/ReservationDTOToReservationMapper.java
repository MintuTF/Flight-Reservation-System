package edu.miu.cs.flightreservation.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.flightreservation.dto.FlightDTO;
import edu.miu.cs.flightreservation.dto.ReservationDTO;
import edu.miu.cs.flightreservation.model.Flight;
import edu.miu.cs.flightreservation.model.Reservation;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationDTOToReservationMapper extends BaseMapper<ReservationDTO, Reservation> {
    @Autowired
    public ReservationDTOToReservationMapper(MapperFactory mapperFactory) {
        super(mapperFactory, ReservationDTO.class, Reservation.class);
    }
}
