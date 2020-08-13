package com.techriders.frontservice.repositories;


import com.techriders.frontservice.domains.Category;
import com.techriders.frontservice.domains.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {


}
