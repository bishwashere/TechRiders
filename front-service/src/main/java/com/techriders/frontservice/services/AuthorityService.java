package com.techriders.frontservice.services;

import com.techriders.frontservice.domains.Authority;

public interface AuthorityService {
    Authority findByAuthorityId(String role_buyer);
}
