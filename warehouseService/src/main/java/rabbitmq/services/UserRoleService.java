package rabbitmq.services;


import com.warehouseService.rabbitmq.domains.UserRole;

public interface UserRoleService {
    UserRole findByRoleName(String role_buyer);
}
