package TallerMecanico.mapper;

import TallerMecanico.dtos.OrdenServicio.OrdenServicioGetDTO;
import TallerMecanico.dtos.OrdenServicio.OrdenServicioPostDTO;
import TallerMecanico.dtos.OrdenServicio.OrdenServicioPutDTO;
import TallerMecanico.entity.*;
import TallerMecanico.enums.EstadoOrden;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrdenServicioMapper {

    public static OrdenServicioGetDTO toDto(OrdenServicioEntity entity) {

        if (entity == null) return null;

        OrdenServicioGetDTO dto = new OrdenServicioGetDTO();

        dto.setIdOrdenServicio(entity.getIdOrdenServicio());
        dto.setEstadoOrden(entity.getEstadoOrden().name());
        dto.setNombreMecanico(entity.getMecanico().getNombres());
        dto.setFechaIngreso(entity.getFechaIngreso());
        dto.setHoraEntrada(entity.getHoraEntrada());
        dto.setHoraSalidaEstimada(entity.getHoraSalidaEstimada());
        dto.setNombreTipoServicio(entity.getTipoServicio().getNombreServicio());

        return dto;
    }

    public static OrdenServicioEntity toEntity(OrdenServicioPostDTO dto, VehiculoEntity vehiculo, ClienteEntity cliente, MecanicoEntity mecanico, TipoServicioEntity tipo) {

        if (dto == null) return null;

        OrdenServicioEntity entity = new OrdenServicioEntity();

        entity.setVehiculo(vehiculo);
        entity.setCliente(cliente);
        entity.setMecanico(mecanico);
        entity.setTipoServicio(tipo);

        entity.setEstadoOrden(EstadoOrden.PENDIENTE);
        entity.setFechaIngreso(dto.getFechaIngreso());
        entity.setHoraEntrada(dto.getHoraEntrada());
        entity.setHoraSalidaEstimada(dto.getHoraSalidaEstimada());

        return entity;
    }

    public static OrdenServicioEntity toEntity(OrdenServicioPutDTO dto, OrdenServicioEntity orden) {
        if (dto == null) return null;

        if (dto.getEstadoOrden() != null) orden.setEstadoOrden(EstadoOrden.valueOf(dto.getEstadoOrden()));
        if (dto.getFechaIngreso() != null) orden.setFechaIngreso(dto.getFechaIngreso());
        if (dto.getHoraEntrada() != null) orden.setHoraEntrada(dto.getHoraEntrada());
        if (dto.getHoraSalidaEstimada() != null) orden.setHoraSalidaEstimada(dto.getHoraSalidaEstimada());

        return orden;
    }
}