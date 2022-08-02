package uz.pdp.bankamattizimi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankamattizimi.entity.Employee;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    boolean existsByEmail(String email);

    Optional<Employee> findByEmailAndEmailCode(String email, String emailCode);


    Optional<Employee> findByEmail(String email);
}
