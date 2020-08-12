package com.techriders.frontservice.services.impl;

import com.techriders.frontservice.domains.Authority;
import com.techriders.frontservice.repositories.AuthorityRepository;
import com.techriders.frontservice.services.AuthorityService;
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
