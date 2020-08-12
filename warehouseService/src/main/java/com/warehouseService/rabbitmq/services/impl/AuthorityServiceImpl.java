package com.warehouseService.rabbitmq.services.impl;


import com.warehouseService.rabbitmq.domains.Authority;
import com.warehouseService.rabbitmq.repositories.AuthorityRepository;
import com.warehouseService.rabbitmq.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public Authority findByAuthorityId(String authority) {
        return authorityRepository.findByAuthority(authority);
    }
}
