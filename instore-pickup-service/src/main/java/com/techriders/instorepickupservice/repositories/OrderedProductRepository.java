package com.techriders.instorepickupservice.repositories;


import com.techriders.instorepickupservice.domains.OrderedProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedProductRepository extends CrudRepository<OrderedProduct,Long> {

    OrderedProduct findByProductId(Long id);
}

