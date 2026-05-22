package TallerMecanico.repository;

import TallerMecanico.entity.OrdenServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicioEntity, Long> {
    List<OrdenServicioEntity> findByCliente_IdCliente(Long IdPaciente);
}
