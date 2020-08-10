package com.techriders.wirehouseservice.services;


import com.techriders.wirehouseservice.domains.BillingAddress;

import java.util.List;

public interface BillingAddressService {

    public BillingAddress save(BillingAddress billingAddress);
    public List<BillingAddress> getAllBillingAddress();

    public BillingAddress findById(long id);

    public void delete(BillingAddress billingAddress);
}
