package TallerMecanico.service;

import TallerMecanico.dtos.DetallesServicio.DetallesServicioGetDTO;
import TallerMecanico.dtos.DetallesServicio.DetallesServicioPostDTO;
import TallerMecanico.dtos.DetallesServicio.DetallesServicioUpdateDTO;
import TallerMecanico.entity.DetallesServicioEntity;
import TallerMecanico.entity.OrdenServicioEntity;
import TallerMecanico.entity.PaqueteServicioEntity;
import TallerMecanico.entity.RefaccionEntity;
import TallerMecanico.mapper.DetallesServicioMapper;
import TallerMecanico.repository.DetallesServicioRepository;
import TallerMecanico.repository.OrdenServicioRepository;
import TallerMecanico.repository.PaqueteServicioRepository;
import TallerMecanico.repository.RefaccionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DetallesServicio {
    private final OrdenServicioRepository ordenServicioRepository;
    private final DetallesServicioRepository detallesServicioRepository;
    private final RefaccionRepository refaccionRepository;

    public DetallesServicio(DetallesServicioRepository detallesServicioRepository, PaqueteServicioRepository paqueteServicioRepository, RefaccionRepository refaccionRepository, OrdenServicioRepository ordenServicioRepository) {
        this.detallesServicioRepository = detallesServicioRepository;
        this.refaccionRepository = refaccionRepository;
        this.ordenServicioRepository = ordenServicioRepository;
    }

    public List<DetallesServicioGetDTO> obtenerTodos() {
        return detallesServicioRepository.findAll().stream()
                .map(DetallesServicioMapper::toDto)
                .collect(Collectors.toList());
    }

    public DetallesServicioGetDTO obtenerPorId(Long id) {
        DetallesServicioEntity detalle = detallesServicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de servicio no encontrado con ID: " + id));
        return DetallesServicioMapper.toDto(detalle);
    }

    public List<DetallesServicioGetDTO> obtenerPorPaquete(Long idPaquete) {
        // Asumiendo que en tu repository el método se actualizó a findByPaquete_IdPaquete
        return detallesServicioRepository.findByPaquete_IdPaquete(idPaquete).stream()
                .map(DetallesServicioMapper::toDto)
                .collect(Collectors.toList());
    }

    public DetallesServicioGetDTO insertarDetalle(DetallesServicioPostDTO dto) {
        OrdenServicioEntity orden = ordenServicioRepository.findById(dto.getIdOrdenServicio())
                .orElseThrow(() -> new RuntimeException("Paquete no encontrado con ID: " + dto.getIdOrdenServicio()));

        RefaccionEntity refaccion = refaccionRepository.findById(dto.getIdRefaccion())
                .orElseThrow(() -> new RuntimeException("Refacción no encontrada con ID: " + dto.getIdRefaccion()));

        DetallesServicioEntity nuevoDetalle = DetallesServicioMapper.toEntity(dto, orden, refaccion);
        log.info("Detalle de servicio guardado con éxito");

        return DetallesServicioMapper.toDto(detallesServicioRepository.save(nuevoDetalle));
    }

    @Transactional
    public void actualizarDetalle(Long id, DetallesServicioUpdateDTO dto) {
        DetallesServicioEntity entity = detallesServicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de servicio no encontrado con ID: " + id));
        DetallesServicioMapper.updateEntity(dto, entity);
    }

    @Transactional
    public void desactivarDetalle(Long id) {
        DetallesServicioEntity entity = detallesServicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de servicio no encontrado con ID: " + id));
        detallesServicioRepository.delete(entity);
        log.info("Detalle de servicio con ID {} eliminado", id);
    }
}
