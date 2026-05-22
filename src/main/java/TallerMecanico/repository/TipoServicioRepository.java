package TallerMecanico.repository;

import TallerMecanico.entity.TipoServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicioRepository extends JpaRepository<TipoServicioEntity, Long> {
}
