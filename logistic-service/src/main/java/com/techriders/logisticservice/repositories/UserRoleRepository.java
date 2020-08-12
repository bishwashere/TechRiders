package com.techriders.logisticservice.repositories;

import com.techriders.logisticservice.domains.User;
import com.techriders.logisticservice.domains.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Long> {
    public UserRole findByRoleName(String roleName);

    public List<UserRole>findAllByUsers(User user);
}
