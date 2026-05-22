package TallerMecanico.service;

import TallerMecanico.dtos.TipoServicio.TipoServicioGetDTO;
import TallerMecanico.entity.TipoServicioEntity;
import TallerMecanico.mapper.TipoServicioMapper;
import TallerMecanico.repository.TipoServicioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TipoServicio {

    private final TipoServicioRepository repository;

    public TipoServicio(TipoServicioRepository repository) {
        this.repository = repository;
    }

    public List<TipoServicioGetDTO> obtenerTodos() {
        log.info("Consultando catálogo de tipos de servicio");
        return repository.findAll().stream().map(TipoServicioMapper::toDto).collect(Collectors.toList());
    }

    public TipoServicioGetDTO obtenerPorId(Long id) {
        TipoServicioEntity tipo = repository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de servicio no encontrado con ID: " + id));
        return TipoServicioMapper.toDto(tipo);
    }
}