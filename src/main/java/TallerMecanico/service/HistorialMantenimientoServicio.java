package TallerMecanico.service;

import TallerMecanico.dtos.HistorialMantenimiento.HistorialMantenimientoGetDTO;
import TallerMecanico.dtos.HistorialMantenimiento.HistorialMantenimientoPostDTO;
import TallerMecanico.dtos.HistorialMantenimiento.HistorialMantenimientoUpdateDTO;
import TallerMecanico.entity.HistorialMantenimientoEntity;
import TallerMecanico.entity.MecanicoEntity;
import TallerMecanico.entity.VehiculoEntity;
import TallerMecanico.mapper.HistorialMantenimientoMapper;
import TallerMecanico.repository.HistorialMantenimientoRepository;
import TallerMecanico.repository.MecanicoRepository;
import TallerMecanico.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistorialMantenimientoServicio {

    private final HistorialMantenimientoRepository historialRepository;
    private final VehiculoRepository vehiculoRepository;
    private final MecanicoRepository mecanicoRepository;

    public List<HistorialMantenimientoGetDTO> obtenerTodos() {
        return historialRepository.findAll().stream()
                .map(HistorialMantenimientoMapper::toDto)
                .collect(Collectors.toList());
    }

    public HistorialMantenimientoGetDTO obtenerPorId(Long id) {
        HistorialMantenimientoEntity historial = historialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado con ID: " + id));
        return HistorialMantenimientoMapper.toDto(historial);
    }

    public List<HistorialMantenimientoGetDTO> obtenerPorVehiculo(Long idVehiculo) {
        // Cambiado de Paciente a Vehículo para que coincida con tu nueva lógica
        return historialRepository.findByVehiculo_IdVehiculo(idVehiculo).stream()
                .map(HistorialMantenimientoMapper::toDto)
                .collect(Collectors.toList());
    }

    public HistorialMantenimientoGetDTO insertarHistorial(HistorialMantenimientoPostDTO dto) {
        // Buscamos el vehículo en lugar del paciente
        VehiculoEntity vehiculo = vehiculoRepository.findById(dto.getIdVehiculo())
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + dto.getIdVehiculo()));

        MecanicoEntity mecanico = mecanicoRepository.findById(dto.getIdMecanico())
                .orElseThrow(() -> new RuntimeException("Mecánico no encontrado con ID: " + dto.getIdMecanico()));

        HistorialMantenimientoEntity nuevoHistorial = HistorialMantenimientoMapper.toEntity(dto, vehiculo, mecanico);

        log.info("Historial de mantenimiento generado con éxito");
        return HistorialMantenimientoMapper.toDto(historialRepository.save(nuevoHistorial));
    }

    @Transactional
    public void actualizarHistorial(Long id, HistorialMantenimientoUpdateDTO dto) {
        HistorialMantenimientoEntity entity = historialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado con ID: " + id));
        HistorialMantenimientoMapper.updateEntity(dto, entity);
        log.info("Historial con ID {} actualizado", id);
    }
}