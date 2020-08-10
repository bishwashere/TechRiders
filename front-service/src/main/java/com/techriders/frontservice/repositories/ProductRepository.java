package com.techriders.frontservice.repositories;


import com.techriders.frontservice.domains.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findAllByAddedBy(Long id);

    @Modifying
    @Query("update Product p set p.soldStatus = true where p.id = ?1")
    List<Product> updateSoldStatusByIds(List<Long> ids);
}
