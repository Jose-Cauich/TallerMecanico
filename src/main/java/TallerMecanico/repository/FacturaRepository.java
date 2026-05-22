package TallerMecanico.repository;

import TallerMecanico.entity.FacturasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<FacturasEntity, Long> {

    Optional<FacturasEntity> findByPago_IdPago (Long idPago);
}
