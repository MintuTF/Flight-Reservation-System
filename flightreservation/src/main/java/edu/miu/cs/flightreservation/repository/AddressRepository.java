package edu.miu.cs.flightreservation.repository;

import edu.miu.cs.flightreservation.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
}