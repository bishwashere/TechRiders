package com.techriders.wirehouseservice.repositories;


import com.techriders.wirehouseservice.domains.Content;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends CrudRepository<Content,String>{

    @Query(value ="select * from Content c where c.slug = :slug", nativeQuery = true)
    Content getContentBySlug(String slug);
}
