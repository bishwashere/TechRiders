package com.techriders.instorepickupservice.services.impl;


import com.techriders.instorepickupservice.domains.ShippingAddress;
import com.techriders.instorepickupservice.repositories.ShippingAddressRepository;
import com.techriders.instorepickupservice.services.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShippingAddresImpl implements ShippingAddressService {
    @Autowired
    ShippingAddressRepository shippingAddressRepository;


    @Override
    public ShippingAddress save(ShippingAddress shippingAddress){
        return shippingAddressRepository.save(shippingAddress);
    }
    @Override
    public List<ShippingAddress> getAllShippingAddress(){
        return shippingAddressRepository.findAll();
    }

    @Override
    public ShippingAddress findById(long id) {
        return shippingAddressRepository.findById(id);
    }
    @Override
    public void delete(ShippingAddress shippingAddress) {
        shippingAddressRepository.delete(shippingAddress);
    }
}
