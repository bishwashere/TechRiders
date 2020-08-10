package com.techriders.wirehouseservice.services;


import com.techriders.wirehouseservice.domains.OrderedProduct;

public interface OrderedProductService {

    OrderedProduct findByProductId(Long id);
}
