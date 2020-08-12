package com.techriders.logisticservice.services.impl;


import com.techriders.logisticservice.domains.UserRole;
import com.techriders.logisticservice.repositories.UserRoleRepository;
import com.techriders.logisticservice.services.UserRoleService;
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
