package com.warehouseService.rabbitmq.repositories;

import com.warehouseService.rabbitmq.domains.UserGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends CrudRepository<UserGroup,Long> {
    public UserGroup findByGroupName(String authority);
}
