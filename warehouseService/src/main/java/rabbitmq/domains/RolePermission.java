package rabbitmq.domains;

import com.warehouseService.rabbitmq.domains.UserRole;

import javax.persistence.*;
import java.util.List;

@Entity
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "rolePermissions")
    private List<com.warehouseService.rabbitmq.domains.UserRole> userRoles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.warehouseService.rabbitmq.domains.UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
