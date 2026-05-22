package TallerMecanico.service;

import TallerMecanico.dtos.Vehiculo.VehiculoGetDTO;
import TallerMecanico.dtos.Vehiculo.VehiculoPostDTO;
import TallerMecanico.dtos.Vehiculo.VehiculoUpdateDTO;
import TallerMecanico.entity.ClienteEntity;
import TallerMecanico.entity.VehiculoEntity;
import TallerMecanico.mapper.VehiculoMapper;
import TallerMecanico.repository.ClienteRepository;
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
public class VehiculoServicio {

    private final VehiculoRepository vehiculoRepository;
    private final ClienteRepository clienteRepository;

    public List<VehiculoGetDTO> obtenerTodos() {
        return vehiculoRepository.findAll().stream().map(VehiculoMapper::toDto).collect(Collectors.toList());
    }

    public VehiculoGetDTO obtenerPorId(Long id) {
        VehiculoEntity vehiculo = vehiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + id));
        return VehiculoMapper.toDto(vehiculo);
    }

    public List<VehiculoGetDTO> obtenerPorCliente(Long idCliente) {
        return vehiculoRepository.findById(idCliente).stream().map(VehiculoMapper::toDto).collect(Collectors.toList());
    }

    public VehiculoGetDTO insertarVehiculo(VehiculoPostDTO dto) {
        ClienteEntity cliente = clienteRepository.findById(dto.getIdCliente()).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + dto.getIdCliente()));

        VehiculoEntity nuevoVehiculo = VehiculoMapper.toEntity(dto, cliente);
        log.info("Vehículo con placas {} registrado con éxito", dto.getPlaca());

        return VehiculoMapper.toDto(vehiculoRepository.save(nuevoVehiculo));
    }

    @Transactional
    public void actualizarVehiculo(Long id, VehiculoUpdateDTO dto) {
        VehiculoEntity entity = vehiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + id));

        VehiculoMapper.updateEntity(dto, entity);
        log.info("Vehículo con ID {} actualizado correctamente", id);
    }

    @Transactional
    public void desactivarVehiculo(Long id) {
        VehiculoEntity entity = vehiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + id));

        entity.setActivo(false);
        log.info("Vehículo con ID {} desactivado", id);
    }
}
