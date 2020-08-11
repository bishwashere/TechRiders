package com.techriders.logisticservice.repositories;


import com.techriders.logisticservice.domains.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

    
}
