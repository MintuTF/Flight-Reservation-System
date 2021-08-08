package edu.miu.cs.flightreservation.service;

import edu.miu.cs.flightreservation.model.Address;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AddressService {
    public Address save(Address address);
    public List<Address> findAll();
    public Address findById(Long id);
    public void delete(Address address);
    public void deleteById(Long id);
}
