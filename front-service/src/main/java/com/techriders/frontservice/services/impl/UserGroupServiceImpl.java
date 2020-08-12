package com.techriders.frontservice.services.impl;

import com.techriders.frontservice.domains.UserGroup;
import com.techriders.frontservice.repositories.UserGroupRepository;
import com.techriders.frontservice.services.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    UserGroupRepository userGroupRepository;

    @Override
    public UserGroup findByGroupName(String groupName) {
        return userGroupRepository.findByGroupName(groupName);
    }
}
