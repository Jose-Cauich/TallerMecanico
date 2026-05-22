package TallerMecanico.repository;

import TallerMecanico.entity.PaqueteServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaqueteServicioRepository extends JpaRepository<PaqueteServicioEntity, Long> {

    //findBy + campo en Menu  + campo en Paciente
    List<PaqueteServicioEntity> findByCliente_IdCliente(Long idPaciente);

}
