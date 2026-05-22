package TallerMecanico.repository;

import TallerMecanico.entity.PagosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<PagosEntity, Long> {
}
