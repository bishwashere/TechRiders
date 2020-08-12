package com.warehouseService.rabbitmq.services;


import com.warehouseService.rabbitmq.domains.User;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
    User findByUserName(String username);

    @PreAuthorize("hasPermission(#id,'user-management')")
    List<User> findAll();


    User FindById(Long id);

    @PreAuthorize("hasPermission(#id,'user-management')")
    boolean acceptById(Long id);

    @PreAuthorize("hasPermission(#id,'user-management')")
    boolean declinedById(Long id);

    void addPointsById(Long id, Long points);

    User findById(long id);

    @PreAuthorize("hasPermission(#id,'user-management')")
    List<User> findTop10ByFirstName(String firstName);
}
