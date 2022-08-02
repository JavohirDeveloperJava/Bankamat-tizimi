package uz.pdp.bankamattizimi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.bankamattizimi.entity.Bank;
import uz.pdp.bankamattizimi.entity.CardType;

import java.util.Optional;
import java.util.UUID;
@RepositoryRestResource(path = "cardType")
public interface CardTypeRepository extends JpaRepository<CardType, UUID> {


//    Optional<CardType> findById(String cardTypeId);
}
