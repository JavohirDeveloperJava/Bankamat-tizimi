package uz.pdp.bankamattizimi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankamattizimi.entity.Card;

import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
    boolean existsByNumber(String number);


    Optional<Card>findByActiveAndNumber(boolean active, String number);
}
