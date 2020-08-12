package com.techriders.instorepickupservice.services.impl;


import com.techriders.instorepickupservice.domains.OrderedProduct;
import com.techriders.instorepickupservice.repositories.OrderedProductRepository;
import com.techriders.instorepickupservice.services.OrderedProductService;
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
