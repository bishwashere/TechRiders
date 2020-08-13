package com.techriders.frontservice.services;

import com.techriders.frontservice.domains.UserRole;

public interface UserRoleService {
    UserRole findByRoleName(String role_buyer);
}
