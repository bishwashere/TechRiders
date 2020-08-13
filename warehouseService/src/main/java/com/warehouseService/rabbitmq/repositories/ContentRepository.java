<<<<<<< HEAD:warehouseService/src/main/java/com/techriders/logisticservice/repositories/ContentRepository.java
package com.techriders.logisticservice.repositories;


import com.techriders.logisticservice.domains.Content;
=======
package com.warehouseService.rabbitmq.repositories;


import com.warehouseService.rabbitmq.domains.Content;
>>>>>>> 74e49a5e86fbe11f21dd98e2f840978f217ebe7a:warehouseService/src/main/java/com/warehouseService/rabbitmq/repositories/ContentRepository.java
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends CrudRepository<Content,String>{

    @Query(value ="select c from Content c where c.slug = :slug", nativeQuery = true)
    Content getContentBySlug(String slug);
}
