package com.techriders.instorepickupservice.repositories;


import com.techriders.instorepickupservice.domains.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

    
}
