package com.techriders.frontservice.services.impl;

import com.techriders.frontservice.domains.UserRole;
import com.techriders.frontservice.repositories.UserRoleRepository;
import com.techriders.frontservice.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole findByRoleName(String groupName) {
        return userRoleRepository.findByRoleName(groupName);
    }
}
