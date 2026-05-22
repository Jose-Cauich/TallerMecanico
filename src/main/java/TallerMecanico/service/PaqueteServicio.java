package TallerMecanico.service;

import TallerMecanico.dtos.PaqueteServicio.PaqueteServicioGetDTO;
import TallerMecanico.dtos.PaqueteServicio.PaqueteServicioPostDTO;
import TallerMecanico.dtos.PaqueteServicio.PaqueteServicioUpdateDTO;
import TallerMecanico.entity.ClienteEntity;
import TallerMecanico.entity.MecanicoEntity;
import TallerMecanico.entity.PaqueteServicioEntity;
import TallerMecanico.entity.VehiculoEntity;
import TallerMecanico.mapper.PaqueteServicioMapper;
import TallerMecanico.repository.ClienteRepository;
import TallerMecanico.repository.MecanicoRepository;
import TallerMecanico.repository.PaqueteServicioRepository;
import TallerMecanico.repository.VehiculoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PaqueteServicio {

    @Autowired
    VehiculoRepository vehiculoRepository;
    @Autowired
    private PaqueteServicioRepository paqueteServicioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    public MecanicoRepository mecanicoRepository;

    public List<PaqueteServicioGetDTO> obtenerTodos() {
        return paqueteServicioRepository.findAll().stream().map(PaqueteServicioMapper::toDto).collect(Collectors.toList());
    }

    public PaqueteServicioGetDTO obtenerPorId(Long idPaquete) {
        PaqueteServicioEntity paqueteEntity = paqueteServicioRepository.findById(idPaquete).orElseThrow(() -> new RuntimeException("Paquete no encontrado"));
        return PaqueteServicioMapper.toDto(paqueteEntity);
    }

    public List<PaqueteServicioGetDTO> obtenerPorCliente(Long idCliente) {
        return paqueteServicioRepository.findByCliente_IdCliente(idCliente).stream().map(PaqueteServicioMapper::toDto).collect(Collectors.toList());
    }

    public PaqueteServicioGetDTO insertarPaquete(PaqueteServicioPostDTO dto) {

        VehiculoEntity vehiculo = vehiculoRepository.findById(dto.getIdVehiculo()).orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));
        MecanicoEntity mecanicoEntity = mecanicoRepository.findById(dto.getIdMecanico()).orElseThrow(() -> new RuntimeException("Mecánico no encontrado"));
        PaqueteServicioEntity paqueteEntity = PaqueteServicioMapper.toEntity(dto, vehiculo, mecanicoEntity);
        PaqueteServicioEntity nuevoPaquete = paqueteServicioRepository.save(paqueteEntity);

        log.info("Paquete de servicio generado con éxito.");
        return PaqueteServicioMapper.toDto(nuevoPaquete);
    }

    @Transactional
    public void actualizarPaquete(Long id, PaqueteServicioUpdateDTO dto) {
        PaqueteServicioEntity entity = paqueteServicioRepository.findById(id).orElseThrow(() -> new RuntimeException("Paquete no encontrado"));
        PaqueteServicioMapper.updateEntity(dto, entity);
        log.info("Paquete con ID {} actualizado", id);
    }

    @Transactional
    public void desactivarPaquete(Long id) {
        PaqueteServicioEntity entity = paqueteServicioRepository.findById(id).orElseThrow(() -> new RuntimeException("Paquete no encontrado"));
        entity.setActivo(false);
        log.info("Paquete con ID {} desactivado", id);
    }
}
