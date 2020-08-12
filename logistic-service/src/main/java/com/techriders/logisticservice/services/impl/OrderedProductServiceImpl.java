package com.techriders.logisticservice.services.impl;


import com.techriders.logisticservice.domains.OrderedProduct;
import com.techriders.logisticservice.repositories.OrderedProductRepository;
import com.techriders.logisticservice.services.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
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
