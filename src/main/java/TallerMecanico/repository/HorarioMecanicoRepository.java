package TallerMecanico.repository;

import TallerMecanico.entity.HorarioMecanicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioMecanicoRepository extends JpaRepository<HorarioMecanicoEntity, Long> {

    List<HorarioMecanicoEntity> findByMecanico_IdMecanico(Long idNutriologa);


}
