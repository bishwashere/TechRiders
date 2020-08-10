package com.techriders.frontservice.repositories;


import com.techriders.frontservice.domains.ShippingAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {
    public List<ShippingAddress> findAll();
    public ShippingAddress findById(long id);
}
