package com.techriders.wirehouseservice.services.impl;

import com.techriders.wirehouseservice.domains.Product;

import com.techriders.wirehouseservice.repositories.ProductRepository;
import com.techriders.wirehouseservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> findAllByAddedBy(Long id) {
        return productRepository.findAllByAddedBy(id);
    }

    @Override
    public Optional<Product> deleteById(Long id) {
        productRepository.deleteById(id);
        return null;
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> updateSoldStatusByIds(List<Long> ids) {
        return productRepository.updateSoldStatusByIds(ids);
    }
}
