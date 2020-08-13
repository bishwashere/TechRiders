package com.warehouseService.rabbitmq.repositories;


import com.warehouseService.rabbitmq.domains.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findByEmail(String email);
    User findByUserName(String username);

    @Modifying
    @Query("update User u set u.adminVerification = ?1 where u.id = ?2")
    Integer changeStatus(Short status, Long id);



    List<User>findTop10ByFirstNameContaining(String firstName);
}
