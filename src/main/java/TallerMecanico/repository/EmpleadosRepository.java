package TallerMecanico.repository;

import TallerMecanico.entity.EmpleadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadosRepository extends JpaRepository<EmpleadosEntity, Long> {

    Optional<EmpleadosEntity> findByCorreo(String correo);
}
