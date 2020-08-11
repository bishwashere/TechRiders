package com.warehouseService.rabbitmq.services.impl;


import com.warehouseService.rabbitmq.domains.OrderedProduct;
import com.warehouseService.rabbitmq.repositories.OrderedProductRepository;
import com.warehouseService.rabbitmq.services.OrderedProductService;
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
