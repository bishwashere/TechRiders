package com.techriders.logisticservice.services.impl;


import com.techriders.logisticservice.domains.BillingAddress;
import com.techriders.logisticservice.repositories.BillingRepository;
import com.techriders.logisticservice.services.BillingAddressService;
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
