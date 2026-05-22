package TallerMecanico.mapper;

import TallerMecanico.dtos.Empleados.EmpleadosRegisterDTO;
import TallerMecanico.dtos.Empleados.EmpleadosResponseDTO;
import TallerMecanico.dtos.Empleados.EmpleadosUpdateDTO;
import TallerMecanico.dtos.Direccion.DireccionDTO;
import TallerMecanico.entity.DireccionesEntity;
import TallerMecanico.entity.EmpleadosEntity;
import TallerMecanico.entity.RolEntity;
import TallerMecanico.enums.NombreRol;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class EmpleadoMapper {

    public static EmpleadosResponseDTO toDtoGet(EmpleadosEntity entity) {
        if (entity == null) return null;

        EmpleadosResponseDTO dto = new EmpleadosResponseDTO();

        dto.setIdEmpleado(entity.getIdEmpleado());
        dto.setNombres(entity.getNombres());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setCorreo(entity.getCorreo());
        dto.setTelefono(entity.getTelefono());
        dto.setFechaRegistro(entity.getFechaRegistro());
        dto.setRol(entity.getRol().name());
        dto.setDireccion(DireccionesMapper.toDto(entity.getDireccion()));

        return dto;
    }

    public static EmpleadosEntity toEntity(EmpleadosRegisterDTO dto) {
        if (dto == null) return null;

        EmpleadosEntity entity = new EmpleadosEntity();

        entity.setNombres(dto.getNombres());
        entity.setApellidoPaterno(dto.getApellidoPaterno());
        entity.setApellidoMaterno(dto.getApellidoMaterno());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono(dto.getTelefono());
        entity.setPasswordHash(dto.getPassword());
        entity.setFechaRegistro(LocalDateTime.now());
        entity.setActivo(true);

        if (dto.getRol() != null) {
            entity.setRol(NombreRol.valueOf(dto.getRol().toUpperCase()));
        }

        entity.setDireccion(DireccionesMapper.toEntity(dto.getDireccion()));

        return entity;
    }

    public static EmpleadosEntity updateEntity(EmpleadosUpdateDTO dto, EmpleadosEntity entity) {

        if (dto == null || entity == null) return entity;

        if (dto.getNombres() != null) entity.setNombres(dto.getNombres());
        if (dto.getApellidoPaterno() != null) entity.setApellidoPaterno(dto.getApellidoPaterno());
        if (dto.getApellidoMaterno() != null) entity.setApellidoMaterno(dto.getApellidoMaterno());
        if (dto.getCorreo() != null) entity.setCorreo(dto.getCorreo());
        if (dto.getTelefono() != null) entity.setTelefono(dto.getTelefono());
        if (dto.getActivo() != null) entity.setActivo(dto.getActivo());

        if (dto.getDireccion() != null && entity.getDireccion() != null) {
            DireccionesEntity dir = entity.getDireccion();
            DireccionDTO dDto = dto.getDireccion();

            if (dDto.getCalle() != null) dir.setCalle(dDto.getCalle());
            if (dDto.getColonia() != null) dir.setColonia(dDto.getColonia());
            if (dDto.getMunicipio() != null) dir.setMunicipio(dDto.getMunicipio());
            if (dDto.getEstado() != null) dir.setEstado(dDto.getEstado());
            if (dDto.getCodigoPostal() != null) dir.setCodigoPostal(dDto.getCodigoPostal());
        }

        return entity;
    }
}