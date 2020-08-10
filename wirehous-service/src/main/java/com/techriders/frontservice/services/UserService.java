package com.techriders.frontservice.services;


import com.techriders.frontservice.domains.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
    User findByUserName(String username);
//    List<BillingAddress> saveBillingAddressByID(long id);
    List<User> findAll();

    User FindById(Long id);
    boolean acceptById(Long id);
    boolean declinedById(Long id);

    void addPointsById(Long id, Long points);

    User findById(long id);

    List<User> findTop10ByFirstName(String firstName);
}
