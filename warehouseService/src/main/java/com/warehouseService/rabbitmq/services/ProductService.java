package com.warehouseService.rabbitmq.services;


import com.warehouseService.rabbitmq.domains.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product save(Product product);
    public List<Product> findAll();
    public List<Product> findAllByAddedBy(Long id);
    public Optional<Product> deleteById(Long id);

    Optional<Product> findById(long id);

    public List<Product> updateSoldStatusByIds(List<Long> ids);
}
