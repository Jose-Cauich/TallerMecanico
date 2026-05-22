package TallerMecanico.service;

import TallerMecanico.dtos.Mecanico.MecanicoRegisterDTO;
import TallerMecanico.dtos.Mecanico.MecanicoResponseDTO;
import TallerMecanico.dtos.Mecanico.MecanicoUpdateDTO;
import TallerMecanico.entity.MecanicoEntity;
import TallerMecanico.enums.Genero;
import TallerMecanico.mapper.MecanicoMapper;
import TallerMecanico.repository.MecanicoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MecanicoServicio {

    @Autowired
    MecanicoRepository mecanicoRepository;

    public List<MecanicoResponseDTO> obtenerTodos() {
        return mecanicoRepository.findAll().stream().map(MecanicoMapper::toGetDto).collect(Collectors.toList());
    }

    public MecanicoResponseDTO obtenerPorId(Long id) {
        MecanicoEntity mecanico = mecanicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mecánico no encontrado"));
        return MecanicoMapper.toGetDto(mecanico);
    }

    public MecanicoResponseDTO insertarMecanico(MecanicoRegisterDTO dto) {
        MecanicoEntity nuevoMecanico = MecanicoMapper.toEntity(dto);
        log.info("Mecánico registrado con éxito.");
        return MecanicoMapper.toGetDto(mecanicoRepository.save(nuevoMecanico));
    }

    @Transactional
    public void actualizarMecanico(Long id, MecanicoUpdateDTO dto){
        MecanicoEntity entity = mecanicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Mecánico no encontrado"));
        MecanicoMapper.toEntity(dto, entity);
        log.info("Mecánico con ID {} actualizado", id);
    }

    @Transactional
    public void desactivarMecanico(Long id) {
        MecanicoEntity entity = mecanicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Mecánico no encontrado"));
        // Corregí a false para que realmente desactive
        entity.setActivo(false);
        log.info("Mecánico con ID {} desactivado", id);
    }
}

