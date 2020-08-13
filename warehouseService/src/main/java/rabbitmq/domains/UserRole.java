package rabbitmq.domains;
import com.warehouseService.rabbitmq.domains.RolePermission;
import com.warehouseService.rabbitmq.domains.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class UserRole implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 12)
    private String roleName;

    @ManyToMany(mappedBy = "userRoles")
    private List<com.warehouseService.rabbitmq.domains.User> users;

    @ManyToMany
    @JoinTable
    private List<RolePermission> rolePermissions;

    public String toString(){
        return roleName;
    }
    public UserRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<com.warehouseService.rabbitmq.domains.User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }
}
