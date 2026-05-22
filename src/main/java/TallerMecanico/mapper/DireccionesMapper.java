package TallerMecanico.mapper;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import TallerMecanico.entity.DireccionesEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DireccionesMapper {

    public static DireccionesEntity toEntity(DireccionDTO dto) {

        if (dto == null) {
            return null;
        }

        DireccionesEntity direccionesEntity = new DireccionesEntity();
        direccionesEntity.setCalle(dto.getCalle());
        direccionesEntity.setColonia(dto.getColonia());
        direccionesEntity.setMunicipio(dto.getMunicipio());
        direccionesEntity.setEstado(dto.getEstado());
        direccionesEntity.setCodigoPostal(dto.getCodigoPostal());

        return direccionesEntity;
    }

    public static DireccionDTO toDto(DireccionesEntity direccionesEntity) {
        if (direccionesEntity == null) {
            return null;
        }

        DireccionDTO direccionDTO = new DireccionDTO();
        direccionDTO.setCalle(direccionesEntity.getCalle());
        direccionDTO.setColonia(direccionesEntity.getColonia());
        direccionDTO.setMunicipio(direccionesEntity.getMunicipio());
        direccionDTO.setEstado(direccionesEntity.getEstado());
        direccionDTO.setCodigoPostal(direccionesEntity.getCodigoPostal());

        return direccionDTO;
    }
}
