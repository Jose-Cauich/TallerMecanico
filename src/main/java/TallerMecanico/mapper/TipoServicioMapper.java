package TallerMecanico.mapper;

import TallerMecanico.dtos.TipoServicio.TipoServicioGetDTO;
import TallerMecanico.dtos.TipoServicio.TipoServicioPostDTO;
import TallerMecanico.entity.TipoServicioEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TipoServicioMapper {

    public static TipoServicioGetDTO toDto(TipoServicioEntity entity) {
        if (entity == null) return null;

       TipoServicioGetDTO dto = new TipoServicioGetDTO();

        dto.setIdTipoServicio(entity.getIdTipoServicio());
        dto.setNombreServicio(entity.getNombreServicio());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecioBase(entity.getPrecioBase());

        return dto;
    }

    public static TipoServicioEntity toEntity(TipoServicioPostDTO dto) {
        if (dto == null) return null;

        TipoServicioEntity entity = new TipoServicioEntity();

        entity.setNombreServicio(dto.getNombreServicio());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecioBase(dto.getPrecioBase());

        return entity;
    }
}