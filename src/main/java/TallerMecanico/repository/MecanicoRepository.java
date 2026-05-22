package TallerMecanico.repository;

import TallerMecanico.entity.MecanicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MecanicoRepository extends JpaRepository<MecanicoEntity, Long> {

    Optional<MecanicoEntity> findByCorreo(String correo);

}
