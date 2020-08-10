package com.techriders.wirehouseservice.services;


import com.techriders.wirehouseservice.domains.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {

    public ShippingAddress save(ShippingAddress shippingAddress);
    public List<ShippingAddress> getAllShippingAddress();

    public ShippingAddress findById(long id);

    public void delete(ShippingAddress shippingAddress);
}
