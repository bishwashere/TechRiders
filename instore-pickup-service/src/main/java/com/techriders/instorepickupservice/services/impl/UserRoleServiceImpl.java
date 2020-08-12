package com.techriders.instorepickupservice.services.impl;


import com.techriders.instorepickupservice.domains.UserRole;
import com.techriders.instorepickupservice.repositories.UserRoleRepository;
import com.techriders.instorepickupservice.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole findByRoleName(String groupName) {
        return userRoleRepository.findByRoleName(groupName);
    }
}
