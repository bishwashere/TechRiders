package com.warehouseService.rabbitmq.services;


import com.warehouseService.rabbitmq.domains.UserGroup;

public interface UserGroupService {
    UserGroup findByAuthorityId(String role_buyer);
}
