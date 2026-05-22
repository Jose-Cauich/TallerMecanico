package TallerMecanico.repository;

import TallerMecanico.entity.RefaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefaccionRepository extends JpaRepository<RefaccionEntity, Long> {
}
