package com.techriders.logisticservice.services;


import com.techriders.logisticservice.domains.UserRole;

public interface UserRoleService {
    UserRole findByRoleName(String role_buyer);
}
