package com.techriders.instorepickupservice.services;


import com.techriders.instorepickupservice.domains.UserRole;

public interface UserRoleService {
    UserRole findByRoleName(String role_buyer);
}
