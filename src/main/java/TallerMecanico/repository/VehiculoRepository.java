package TallerMecanico.repository;
import TallerMecanico.entity.EmpleadosEntity;
import TallerMecanico.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {
    Optional<EmpleadosEntity> findByCorreo(String correo);

}
