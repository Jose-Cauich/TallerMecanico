package TallerMecanico.repository;

import TallerMecanico.entity.HistorialMantenimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialMantenimientoRepository extends JpaRepository<HistorialMantenimientoEntity, Long> {

    List<HistorialMantenimientoEntity> findByVehiculo_IdVehiculo(Long IdPaciente);

}
