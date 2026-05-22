package TallerMecanico.service;

import TallerMecanico.dtos.Empleados.EmpleadosRegisterDTO;
import TallerMecanico.dtos.Empleados.EmpleadosResponseDTO;
import TallerMecanico.dtos.Empleados.EmpleadosUpdateDTO;
import TallerMecanico.entity.EmpleadosEntity;
import TallerMecanico.entity.RolEntity;
import TallerMecanico.enums.NombreRol;
import TallerMecanico.mapper.EmpleadoMapper;
import TallerMecanico.repository.EmpleadosRepository;
import TallerMecanico.repository.RolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class EmpleadoServicio {

    @Autowired
    EmpleadosRepository empleadoRepository;
    @Autowired
    RolRepository rolRepository;

    public List<EmpleadosResponseDTO> obtenerTodos() {
        return empleadoRepository.findAll().stream().map(EmpleadoMapper::toDtoGet).collect(Collectors.toList());
    }

    public EmpleadosResponseDTO obtenerPorId(Long idEmpleado) {
        EmpleadosEntity entity = empleadoRepository.findById(idEmpleado).orElseThrow(() -> new RuntimeException("No existe el Administrador con el id " + idEmpleado));
        return EmpleadoMapper.toDtoGet(entity);
    }

    public EmpleadosResponseDTO insertarEmpleado(EmpleadosRegisterDTO dto) {

        EmpleadosEntity nuevoEmpleado = EmpleadoMapper.toEntity(dto);
        nuevoEmpleado.setRol(NombreRol.valueOf(dto.getRol().toUpperCase()));
        log.info("Empleado guardado con éxito");
        return EmpleadoMapper.toDtoGet(empleadoRepository.save(nuevoEmpleado));
    }

    @Transactional
    public void actualizarEmpleado(Long id, EmpleadosUpdateDTO dto) {
        EmpleadosEntity entity = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
        EmpleadoMapper.updateEntity(dto, entity);
    }

    @Transactional
    public void desactivarEmpleado(Long id) {
        EmpleadosEntity entity = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
        entity.setActivo(false);
        log.info("Empleado con ID {} desactivado", id);
    }

}
