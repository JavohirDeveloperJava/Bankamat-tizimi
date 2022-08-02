package uz.pdp.bankamattizimi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.bankamattizimi.entity.Bank;

import java.util.UUID;

@RepositoryRestResource(path = "bank")
public interface BankRepository extends JpaRepository<Bank, UUID> {
}
