package uz.pdp.bankamattizimi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.bankamattizimi.entity.ValyutaType;

import java.util.UUID;
@RepositoryRestResource(path = "valyuta")
public interface ValyutaTypeRepository extends JpaRepository<ValyutaType, UUID> {
}
