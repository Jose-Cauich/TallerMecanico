package TallerMecanico.repository;

import TallerMecanico.entity.DetallesServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallesServicioRepository extends JpaRepository<DetallesServicioEntity, Long> {

    List<DetallesServicioEntity> findByPaquete_IdPaquete(Long idMenu);

}
