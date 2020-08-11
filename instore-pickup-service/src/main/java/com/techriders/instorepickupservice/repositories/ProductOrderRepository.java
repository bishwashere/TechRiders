package com.techriders.instorepickupservice.repositories;


import com.techriders.instorepickupservice.domains.ProductOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends CrudRepository<ProductOrder,Long> {
}
