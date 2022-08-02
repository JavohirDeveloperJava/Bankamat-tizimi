package uz.pdp.bankamattizimi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankamattizimi.entity.Bancomat;

import java.util.UUID;

public interface BancomatRepositrory extends JpaRepository<Bancomat, UUID> {
}
