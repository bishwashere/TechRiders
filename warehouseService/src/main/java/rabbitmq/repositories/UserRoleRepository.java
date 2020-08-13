package rabbitmq.repositories;

import com.warehouseService.rabbitmq.domains.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Long> {
    public UserRole findByRoleName(String roleName);
}
