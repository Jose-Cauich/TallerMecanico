package TallerMecanico.mapper;

import TallerMecanico.dtos.DetallesServicio.DetallesServicioGetDTO;
import TallerMecanico.dtos.DetallesServicio.DetallesServicioPostDTO;
import TallerMecanico.dtos.DetallesServicio.DetallesServicioUpdateDTO;
import TallerMecanico.entity.DetallesServicioEntity;
import TallerMecanico.entity.OrdenServicioEntity;
import TallerMecanico.entity.RefaccionEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DetallesServicioMapper {

    public static DetallesServicioGetDTO toDto(DetallesServicioEntity entity) {
        if (entity == null) return null;

        DetallesServicioGetDTO dto = new DetallesServicioGetDTO();
        dto.setIdDetalle(entity.getIdDetalle());
        dto.setIdOrdenServicio(entity.getOrdenServicio().getIdOrdenServicio());
        dto.setIdRefaccion(entity.getRefaccion().getIdRefaccion());
        dto.setTipoTrabajo(entity.getTipoTrabajo());
        dto.setCantidad(entity.getCantidad());
        dto.setPrecioUnitario(entity.getPrecioUnitario());

        return dto;
    }

    public static DetallesServicioEntity toEntity(DetallesServicioPostDTO dto, OrdenServicioEntity ordenServicio, RefaccionEntity refaccion) {
        if (dto == null) return null;

        DetallesServicioEntity entity = new DetallesServicioEntity();
        entity.setOrdenServicio(ordenServicio);
        entity.setRefaccion(refaccion);
        entity.setTipoTrabajo(dto.getTipoTrabajo());
        entity.setCantidad(dto.getCantidad());
        entity.setPrecioUnitario(refaccion.getPrecioUnitario());

        return entity;
    }

    public static DetallesServicioEntity updateEntity(DetallesServicioUpdateDTO dto, DetallesServicioEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getTipoTrabajo() != null) entity.setTipoTrabajo(dto.getTipoTrabajo());
        if (dto.getCantidad() != null) entity.setCantidad(dto.getCantidad());
        if (dto.getPrecioUnitario() != null) entity.setPrecioUnitario(dto.getPrecioUnitario());

        return entity;
    }
}