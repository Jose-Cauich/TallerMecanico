package TallerMecanico.mapper;
import TallerMecanico.dtos.Cliente.ClienteRegisterDTO;
import TallerMecanico.dtos.Cliente.ClienteResponseDTO;
import TallerMecanico.dtos.Cliente.ClienteUpdateDTO;
import TallerMecanico.dtos.Direccion.DireccionDTO;
import TallerMecanico.entity.*;
import TallerMecanico.enums.Genero;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class ClienteMapper {

    public static ClienteResponseDTO toDtoGet(ClienteEntity clienteEntity) {

        if (clienteEntity == null) {
            return null;
        }

        ClienteResponseDTO dto = new ClienteResponseDTO();

        dto.setIdCliente(clienteEntity.getIdCliente());
        dto.setIdMecanico(clienteEntity.getMecanico().getIdMecanico());
        dto.setNombres(clienteEntity.getNombres());
        dto.setApellidoPaterno(clienteEntity.getApellidoPaterno());
        dto.setApellidoMaterno(clienteEntity.getApellidoMaterno());
        dto.setFechaNacimiento(clienteEntity.getFechaNacimiento());
        dto.setTelefono(clienteEntity.getTelefono());
        dto.setCorreo(clienteEntity.getCorreo());
        dto.setFechaRegistro(clienteEntity.getFechaRegistro());

        dto.setDireccion(DireccionesMapper.toDto(clienteEntity.getDireccion()));

        return dto;
    }

    public static ClienteEntity toEntity(ClienteRegisterDTO clienteRegisterDTO, MecanicoEntity mecanico) {

        if (clienteRegisterDTO == null) { return null; }

        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setNombres(clienteRegisterDTO.getNombres());
        clienteEntity.setApellidoPaterno(clienteRegisterDTO.getApellidoPaterno());
        clienteEntity.setApellidoMaterno(clienteRegisterDTO.getApellidoMaterno());
        clienteEntity.setFechaNacimiento(clienteRegisterDTO.getFechaNacimiento());
        clienteEntity.setTelefono(clienteRegisterDTO.getTelefono());
        clienteEntity.setCorreo(clienteRegisterDTO.getCorreo());
        clienteEntity.setPasswordHash(clienteRegisterDTO.getPasswordHash());
        clienteEntity.setFechaRegistro(LocalDateTime.now());
        clienteEntity.setActivo(true);

        clienteEntity.setMecanico(mecanico);
        clienteEntity.setDireccion(DireccionesMapper.toEntity(clienteRegisterDTO.getDireccion()));

        return clienteEntity;
    }

    public static ClienteEntity updateCliente(ClienteUpdateDTO dto, ClienteEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getNombres() != null) entity.setNombres(dto.getNombres());
        if (dto.getApellidoPaterno() != null) entity.setApellidoPaterno(dto.getApellidoPaterno());
        if (dto.getApellidoMaterno() != null) entity.setApellidoMaterno(dto.getApellidoMaterno());
        if (dto.getCorreo() != null) entity.setCorreo(dto.getCorreo());
        if (dto.getTelefono() != null) entity.setTelefono(dto.getTelefono());

        if (dto.getDireccion() != null && entity.getDireccion() != null) {

            DireccionesEntity dir = entity.getDireccion();
            DireccionDTO dDto = dto.getDireccion();

            if (dDto.getCalle() != null) dir.setCalle(dDto.getCalle());
            if (dDto.getCodigoPostal() != null) dir.setCodigoPostal(dDto.getCodigoPostal());
            if (dDto.getMunicipio() != null) dir.setMunicipio(dDto.getMunicipio());
            if (dDto.getEstado() != null) dir.setEstado(dDto.getEstado());
            if (dDto.getColonia() != null) dir.setColonia(dDto.getColonia());
        }

        return entity;
    }
}
