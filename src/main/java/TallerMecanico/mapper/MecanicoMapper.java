package TallerMecanico.mapper;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import TallerMecanico.dtos.Mecanico.MecanicoRegisterDTO;
import TallerMecanico.dtos.Mecanico.MecanicoResponseDTO;
import TallerMecanico.dtos.Mecanico.MecanicoUpdateDTO;
import TallerMecanico.entity.DireccionesEntity;
import TallerMecanico.entity.MecanicoEntity;
import TallerMecanico.enums.Genero;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
@Slf4j
public class MecanicoMapper {

    public static MecanicoResponseDTO toGetDto(MecanicoEntity entity) {
        if (entity == null) return null;

        MecanicoResponseDTO dto = new MecanicoResponseDTO();

        dto.setIdMecanico(entity.getIdMecanico());
        dto.setNombres(entity.getNombres());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setEspecialidad(entity.getEspecialidad());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setTelefono(entity.getTelefono());
        dto.setCorreo(entity.getCorreo());
        dto.setFechaRegistro(entity.getFechaRegistro());

        dto.setDireccion(DireccionesMapper.toDto(entity.getDireccion()));

        return dto;
    }

    public static MecanicoEntity toEntity(MecanicoRegisterDTO dto) {

        if (dto == null) return null;

        MecanicoEntity entity = new MecanicoEntity();

        entity.setNombres(dto.getNombres());
        entity.setApellidoPaterno(dto.getApellidoPaterno());
        entity.setApellidoMaterno(dto.getApellidoMaterno());
        entity.setEspecialidad(dto.getEspecialidad());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setTelefono(dto.getTelefono());
        entity.setCorreo(dto.getCorreo());
        entity.setActivo(true);
        entity.setPasswordHash(dto.getPassword());
        entity.setFechaRegistro(LocalDateTime.now());

        entity.setDireccion(DireccionesMapper.toEntity(dto.getDireccion()));
        return entity;
    }

    public static MecanicoEntity toEntity(MecanicoUpdateDTO dto, MecanicoEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getCorreo() != null) entity.setCorreo(dto.getCorreo());
        if (dto.getTelefono() != null) entity.setTelefono(dto.getTelefono());
        if (dto.getActivo() != null) entity.setActivo(dto.getActivo());
        if (dto.getEspecialidad() != null) entity.setEspecialidad(dto.getEspecialidad());

        if (dto.getDireccion() != null) {

            DireccionesEntity direccion = entity.getDireccion();
            DireccionDTO direccionDTO = dto.getDireccion();

            if (direccionDTO.getCalle() != null) direccion.setCalle(direccionDTO.getCalle());
            if (direccionDTO.getColonia() != null) direccion.setColonia(direccionDTO.getColonia());
            if (direccionDTO.getCodigoPostal()!=null) direccion.setCodigoPostal(direccionDTO.getCodigoPostal());
            if (direccionDTO.getMunicipio()!=null) direccion.setMunicipio(direccionDTO.getMunicipio());
            if (direccionDTO.getEstado() != null) direccion.setEstado(direccionDTO.getEstado());

        }

        return entity;
    }
}
