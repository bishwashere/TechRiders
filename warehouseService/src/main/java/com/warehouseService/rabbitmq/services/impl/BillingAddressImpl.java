package com.warehouseService.rabbitmq.services.impl;


import com.warehouseService.rabbitmq.domains.BillingAddress;
import com.warehouseService.rabbitmq.repositories.BillingRepository;
import com.warehouseService.rabbitmq.services.BillingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
