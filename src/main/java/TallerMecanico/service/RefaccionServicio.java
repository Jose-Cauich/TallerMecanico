package TallerMecanico.service;

import TallerMecanico.dtos.Refaccion.RefaccionGetDTO;
import TallerMecanico.dtos.Refaccion.RefaccionPostDTO;
import TallerMecanico.dtos.Refaccion.RefaccionUpdateDTO;
import TallerMecanico.entity.RefaccionEntity;
import TallerMecanico.mapper.RefaccionMapper;
import TallerMecanico.repository.RefaccionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefaccionServicio {

    private final RefaccionRepository refaccionRepository;

    public List<RefaccionGetDTO> obtenerTodos() {
        return refaccionRepository.findAll().stream()
                .map(RefaccionMapper::toDto)
                .collect(Collectors.toList());
    }

    public RefaccionGetDTO obtenerPorId(Long id) {
        RefaccionEntity refaccion = refaccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Refacción no encontrada con ID: " + id));
        return RefaccionMapper.toDto(refaccion);
    }

    public RefaccionGetDTO insertarRefaccion(RefaccionPostDTO dto) {
        RefaccionEntity nuevaRefaccion = RefaccionMapper.toEntity(dto);
        RefaccionEntity guardada = refaccionRepository.save(nuevaRefaccion);
        log.info("Refacción registrada con éxito");
        return RefaccionMapper.toDto(guardada);
    }

    @Transactional
    public void actualizarRefaccion(Long id, RefaccionUpdateDTO dto) {
        RefaccionEntity entity = refaccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Refacción no encontrada con ID: " + id));
        RefaccionMapper.updateEntity(dto, entity);
        log.info("Refacción con ID {} actualizada", id);
    }

    @Transactional
    public void desactivarRefaccion(Long id) {
        RefaccionEntity entity = refaccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Refacción no encontrada con ID: " + id));
        entity.setDisponible(false);
        log.info("Refacción con ID {} desactivada", id);
    }
}
