package com.warehouseService.rabbitmq.services;


import com.warehouseService.rabbitmq.domains.Authority;

public interface AuthorityService {
    Authority findByAuthorityId(String role_buyer);
}
