package uz.pdp.bankamattizimi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankamattizimi.entity.Input;

import java.util.UUID;

public interface InputRepository extends JpaRepository<Input, UUID> {
}
