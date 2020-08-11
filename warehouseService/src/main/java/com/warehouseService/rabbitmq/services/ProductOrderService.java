package com.warehouseService.rabbitmq.services;


import com.warehouseService.rabbitmq.domains.ProductOrder;

import java.util.List;

public interface ProductOrderService {

    public List<ProductOrder> getAll();

    public ProductOrder save(ProductOrder productOrder);

    public ProductOrder get(Long id);
    public void deleteById(Long id);
}
