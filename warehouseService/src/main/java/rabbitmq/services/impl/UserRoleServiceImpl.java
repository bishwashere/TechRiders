package rabbitmq.services.impl;


import com.warehouseService.rabbitmq.domains.UserRole;
import com.warehouseService.rabbitmq.repositories.UserRoleRepository;
import com.warehouseService.rabbitmq.services.UserRoleService;
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
