package com.techriders.instorepickupservice.services.impl;


import com.techriders.instorepickupservice.domains.ProductOrder;
import com.techriders.instorepickupservice.repositories.ProductOrderRepository;
import com.techriders.instorepickupservice.services.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    ProductOrderRepository productOrderRepository;

    @Override
    public List<ProductOrder> getAll() {
        return (List<ProductOrder>)productOrderRepository.findAll();
    }

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    @Override
    public ProductOrder get(Long id) {
        return productOrderRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        productOrderRepository.deleteById(id);
    }

}
