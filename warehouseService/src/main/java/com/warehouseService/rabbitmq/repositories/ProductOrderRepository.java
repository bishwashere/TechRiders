package com.warehouseService.rabbitmq.repositories;


import com.warehouseService.rabbitmq.domains.ProductOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends CrudRepository<ProductOrder,Long> {
}
