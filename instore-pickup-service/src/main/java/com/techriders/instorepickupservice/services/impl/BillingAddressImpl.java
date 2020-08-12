package com.techriders.instorepickupservice.services.impl;


import com.techriders.instorepickupservice.domains.BillingAddress;
import com.techriders.instorepickupservice.repositories.BillingRepository;
import com.techriders.instorepickupservice.services.BillingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BillingAddressImpl implements BillingAddressService {
    @Autowired
    BillingRepository billingRepository;

    @Transactional
    public BillingAddress save(BillingAddress billingAddress){
        return billingRepository.save(billingAddress);
    }
    @Transactional
    public List<BillingAddress> getAllBillingAddress(){
        return billingRepository.findAll();
    }

    @Transactional
    public BillingAddress findById(long id) {
        return billingRepository.findById(id);
    }
    @Transactional
    public void delete(BillingAddress billingAddress) {
        billingRepository.delete(billingAddress);
    }
}
