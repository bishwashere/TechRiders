package com.warehouseService.rabbitmq.services;


import com.warehouseService.rabbitmq.domains.ProductOrder;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ProductOrderService {

    @PreAuthorize("hasPermission(#id,'order-management')")
    public List<ProductOrder> getAll();

    @PreAuthorize("hasPermission(#id,'order-management')")
    public ProductOrder save(ProductOrder productOrder);

    @PreAuthorize("hasPermission(#id,'order-management')")
    public ProductOrder get(Long id);

    @PreAuthorize("hasPermission(#id,'order-management')")
    public void deleteById(Long id);
}
