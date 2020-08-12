package com.techriders.frontservice.repositories;

import com.techriders.frontservice.domains.UserGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends CrudRepository<UserGroup,Long> {
    public UserGroup findByGroupName(String authority);
}
