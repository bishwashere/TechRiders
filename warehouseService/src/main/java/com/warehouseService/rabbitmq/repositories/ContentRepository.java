package com.warehouseService.rabbitmq.repositories;


import com.warehouseService.rabbitmq.domains.Content;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends CrudRepository<Content,String>{

    @Query(value ="select c from Content c where c.slug = :slug", nativeQuery = true)
    Content getContentBySlug(String slug);
}
