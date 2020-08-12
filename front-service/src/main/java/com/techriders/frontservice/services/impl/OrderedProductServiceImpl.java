package com.techriders.frontservice.services.impl;


import com.techriders.frontservice.domains.OrderedProduct;
import com.techriders.frontservice.repositories.OrderedProductRepository;
import com.techriders.frontservice.services.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class OrderedProductServiceImpl implements OrderedProductService {

    @Autowired
    OrderedProductRepository orderedProductRepository;

    @Override
    public OrderedProduct findByProductId(Long id) {
        return orderedProductRepository.findByProductId(id);
    }
    
    public void receiveMessage(String message) {
		System.out.println("Received at orderedProductServiceImpl - " + message);
	}
}
