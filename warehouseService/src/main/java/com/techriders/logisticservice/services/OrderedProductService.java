package com.techriders.logisticservice.services;


import com.techriders.logisticservice.domains.OrderedProduct;

public interface OrderedProductService {

    OrderedProduct findByProductId(Long id);
}
