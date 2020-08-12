package com.warehouseService.rabbitmq.services.impl;


import com.warehouseService.rabbitmq.domains.UserGroup;
import com.warehouseService.rabbitmq.repositories.UserGroupRepository;
import com.warehouseService.rabbitmq.services.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    UserGroupRepository userGroupRepository;

    @Override
    public UserGroup findByAuthorityId(String authority) {
        return userGroupRepository.findByGroupName(authority);
    }
}
