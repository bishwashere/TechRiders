package com.warehouseService.rabbitmq.services;


import com.warehouseService.rabbitmq.domains.ProductOrder;
import com.warehouseService.rabbitmq.domains.User;
import javassist.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ProductOrderService {

    @PreAuthorize("hasPermission(#noArgs,'order-management')")
    public List<ProductOrder> getAll();

    @PreAuthorize("hasPermission(#productOrder,'order-management')")
    public ProductOrder save(ProductOrder productOrder);

    @PreAuthorize("hasPermission(#id,'order-management')")
    public ProductOrder get(Long id);

    @PreAuthorize("hasPermission(#id,'order-management')")
    public void deleteById(Long id);

    @PreAuthorize("hasPermission(#status,'order-management')")
    public List<ProductOrder> findByStatus(String status);

    @PreAuthorize("hasPermission(#user,'order-management')")
    public List<ProductOrder> findByBuyer(User user);

    public ProductOrder changeStatus(String status, Long id) throws NotFoundException;
}
