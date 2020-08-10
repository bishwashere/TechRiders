package com.techriders.frontservice.services;


import com.techriders.frontservice.domains.OrderedProduct;

public interface OrderedProductService {

    OrderedProduct findByProductId(Long id);
}
