package com.techriders.wirehouseservice.services.impl;


import com.techriders.wirehouseservice.domains.OrderedProduct;
import com.techriders.wirehouseservice.repositories.OrderedProductRepository;
import com.techriders.wirehouseservice.services.OrderedProductService;
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
}
