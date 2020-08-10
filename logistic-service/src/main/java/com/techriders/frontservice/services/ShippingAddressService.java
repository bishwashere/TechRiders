package com.techriders.frontservice.services;


import com.techriders.frontservice.domains.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {

    public ShippingAddress save(ShippingAddress shippingAddress);
    public List<ShippingAddress> getAllShippingAddress();

    public ShippingAddress findById(long id);

    public void delete(ShippingAddress shippingAddress);
}
