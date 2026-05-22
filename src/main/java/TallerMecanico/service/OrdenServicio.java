package TallerMecanico.service;

import TallerMecanico.dtos.OrdenServicio.OrdenServicioGetDTO;
import TallerMecanico.dtos.OrdenServicio.OrdenServicioPostDTO;
import TallerMecanico.dtos.OrdenServicio.OrdenServicioPutDTO;
import TallerMecanico.entity.*;
import TallerMecanico.mapper.OrdenServicioMapper;
import TallerMecanico.mapper.VehiculoMapper;
import TallerMecanico.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrdenServicio {

    @Autowired
    VehiculoRepository vehiculoRepository;
    @Autowired
    private OrdenServicioRepository ordenServicioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private MecanicoRepository mecanicoRepository;
    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    public List<OrdenServicioGetDTO> obtenerPorCliente(Long clienteId) {
        return ordenServicioRepository.findByCliente_IdCliente(clienteId).stream()
                .map(OrdenServicioMapper::toDto)
                .collect(Collectors.toList());
    }

    public OrdenServicioGetDTO obtenerPorId(Long ordenId) {
        OrdenServicioEntity orden = ordenServicioRepository.findById(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden de servicio no encontrada"));
        return OrdenServicioMapper.toDto(orden);
    }

    public OrdenServicioGetDTO insertarOrden(OrdenServicioPostDTO dto) {

        VehiculoEntity  vehiculo  = vehiculoRepository.findById(dto.getIdVehiculo()).orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));
        ClienteEntity cliente = clienteRepository.findById(dto.getIdCliente()).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        MecanicoEntity mecanico = mecanicoRepository.findById(dto.getIdMecanico()).orElseThrow(() -> new RuntimeException("Mecánico no encontrado"));
        TipoServicioEntity tipo = tipoServicioRepository.findById(dto.getIdTipoServicio()).orElseThrow(() -> new RuntimeException("Tipo de servicio no válido"));
        OrdenServicioEntity entity = OrdenServicioMapper.toEntity(dto,vehiculo, cliente, mecanico, tipo);

        log.info("Orden de servicio registrada con éxito");
        return OrdenServicioMapper.toDto(ordenServicioRepository.save(entity));
    }

    @Transactional
    public void actualizarOrden(Long ordenId, OrdenServicioPutDTO dto) {
        OrdenServicioEntity orden = ordenServicioRepository.findById(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden de servicio no encontrada"));

        OrdenServicioMapper.toEntity(dto, orden);
        log.info("Orden de servicio con ID {} actualizada", ordenId);
    }

    @Transactional
    public void eliminarOrden(Long ordenId) {
        if (!ordenServicioRepository.existsById(ordenId)) {
            throw new RuntimeException("No se puede eliminar: Orden no encontrada");
        }
        ordenServicioRepository.deleteById(ordenId);
        log.info("Orden de servicio con ID {} eliminada", ordenId);
    }
}