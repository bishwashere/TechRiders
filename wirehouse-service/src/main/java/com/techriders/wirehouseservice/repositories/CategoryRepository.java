package com.techriders.wirehouseservice.repositories;


import com.techriders.wirehouseservice.domains.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

    
}
