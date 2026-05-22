package TallerMecanico.mapper;

import TallerMecanico.dtos.Rol.RolRequestDTO;
import TallerMecanico.dtos.Rol.RolResponseDTO;
import TallerMecanico.entity.RolEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RolesMapper {

    public static RolResponseDTO toDto(RolEntity entity) {
        if (entity == null) return null;

        RolResponseDTO dto = new RolResponseDTO();

        dto.setIdRol(entity.getIdRol());
        dto.setNombre(entity.getNombreRol().name());
        return dto;
    }

    public static RolEntity toEntity(RolRequestDTO dto) {
        if (dto == null) return null;

        RolEntity entity = new RolEntity();

        entity.setNombreRol(dto.getNombre());
        return entity;
    }
}