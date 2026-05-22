package TallerMecanico.service;

import TallerMecanico.dtos.HorarioMecanico.HorarioMecanicoGetDTO;
import TallerMecanico.dtos.HorarioMecanico.HorarioMecanicoPostDTO;
import TallerMecanico.dtos.HorarioMecanico.HorarioMecanicoUpdateDTO;
import TallerMecanico.entity.HorarioMecanicoEntity;
import TallerMecanico.entity.MecanicoEntity;
import TallerMecanico.mapper.HorarioMecanicoMapper;
import TallerMecanico.repository.HorarioMecanicoRepository;
import TallerMecanico.repository.MecanicoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HorarioMecanicoServicio {

    private final HorarioMecanicoRepository horarioRepository;
    private final MecanicoRepository mecanicoRepository;

    public List<HorarioMecanicoGetDTO> obtenerTodos() {
        return horarioRepository.findAll().stream()
                .map(HorarioMecanicoMapper::toDto)
                .collect(Collectors.toList());
    }

    public HorarioMecanicoGetDTO obtenerPorId(Long id) {
        HorarioMecanicoEntity horario = horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));
        return HorarioMecanicoMapper.toDto(horario);
    }

    public List<HorarioMecanicoGetDTO> obtenerPorMecanico(Long idMecanico) {
        // Cambiado de Nutriologa a Mecanico para coincidir con la nueva lógica
        return horarioRepository.findByMecanico_IdMecanico(idMecanico).stream()
                .map(HorarioMecanicoMapper::toDto)
                .collect(Collectors.toList());
    }

    public HorarioMecanicoGetDTO insertarHorario(HorarioMecanicoPostDTO dto) {
        MecanicoEntity mecanico = mecanicoRepository.findById(dto.getIdMecanico())
                .orElseThrow(() -> new RuntimeException("Mecánico no encontrado con ID: " + dto.getIdMecanico()));

        HorarioMecanicoEntity nuevoHorario = HorarioMecanicoMapper.toEntity(dto, mecanico);
        log.info("Horario de mecánico guardado con éxito");
        return HorarioMecanicoMapper.toDto(horarioRepository.save(nuevoHorario));
    }

    @Transactional
    public void actualizarHorario(Long id, HorarioMecanicoUpdateDTO dto) {
        HorarioMecanicoEntity entity = horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));
        HorarioMecanicoMapper.updateEntity(dto, entity);
    }

    @Transactional
    public void desactivarHorario(Long id) {
        HorarioMecanicoEntity entity = horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));
        entity.setActivo(false);
        log.info("Horario con ID {} desactivado", id);
    }
}