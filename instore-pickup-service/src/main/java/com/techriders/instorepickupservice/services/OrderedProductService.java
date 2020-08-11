package com.techriders.instorepickupservice.services;


import com.techriders.instorepickupservice.domains.OrderedProduct;

public interface OrderedProductService {

    OrderedProduct findByProductId(Long id);
}
