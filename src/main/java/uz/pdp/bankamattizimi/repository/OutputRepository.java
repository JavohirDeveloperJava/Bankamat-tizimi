package uz.pdp.bankamattizimi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankamattizimi.entity.Output;

import java.util.UUID;

public interface OutputRepository extends JpaRepository<Output, UUID> {
}
