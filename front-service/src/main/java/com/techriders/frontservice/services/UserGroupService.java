package com.techriders.frontservice.services;

import com.techriders.frontservice.domains.UserGroup;

public interface UserGroupService {
    UserGroup findByGroupName(String role_buyer);
}
