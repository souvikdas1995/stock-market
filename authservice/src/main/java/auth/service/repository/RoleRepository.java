package auth.service.repository;

import auth.service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName (String roleName);
    Boolean existsByRoleName(String roleName);
}
