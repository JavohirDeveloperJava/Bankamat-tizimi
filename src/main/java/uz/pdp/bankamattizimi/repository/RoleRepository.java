package uz.pdp.bankamattizimi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankamattizimi.entity.Role;
import uz.pdp.bankamattizimi.entity.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByRoleName(RoleName roleName);
}
