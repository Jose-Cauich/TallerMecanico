package TallerMecanico.mapper;

import TallerMecanico.dtos.HistorialMantenimiento.HistorialMantenimientoGetDTO;
import TallerMecanico.dtos.HistorialMantenimiento.HistorialMantenimientoPostDTO;
import TallerMecanico.dtos.HistorialMantenimiento.HistorialMantenimientoUpdateDTO;
import TallerMecanico.entity.HistorialMantenimientoEntity;
import TallerMecanico.entity.MecanicoEntity;
import TallerMecanico.entity.VehiculoEntity;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
public class HistorialMantenimientoMapper {

    public static HistorialMantenimientoGetDTO toDto(HistorialMantenimientoEntity entity) {
        if (entity == null) return null;

        HistorialMantenimientoGetDTO dto = new HistorialMantenimientoGetDTO();

        dto.setIdHistorial(entity.getIdHistorial());
        dto.setIdVehiculo(entity.getVehiculo().getIdVehiculo());
        dto.setIdMecanico(entity.getMecanico().getIdMecanico());
        dto.setFechaServicio(entity.getFechaServicio());
        dto.setDiagnosticoTecnico(entity.getDiagnosticoTecnico());
        dto.setObservaciones(entity.getObservaciones());
        dto.setTrabajoRealizado(entity.getTrabajoRealizado());
        dto.setRefaccionesCambiadas(entity.getRefaccionesCambiadas());

        return dto;
    }

    public static HistorialMantenimientoEntity toEntity(HistorialMantenimientoPostDTO dto, VehiculoEntity vehiculo, MecanicoEntity mecanico) {
        if (dto == null) return null;

        HistorialMantenimientoEntity entity = new HistorialMantenimientoEntity();

        entity.setVehiculo(vehiculo);
        entity.setMecanico(mecanico);
        entity.setDiagnosticoTecnico(dto.getDiagnosticoTecnico());
        entity.setObservaciones(dto.getObservaciones());
        entity.setTrabajoRealizado(dto.getTrabajoRealizado());
        entity.setFechaServicio(LocalDateTime.now());

        return entity;
    }

    public static HistorialMantenimientoEntity updateEntity(HistorialMantenimientoUpdateDTO dto, HistorialMantenimientoEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getDiagnosticoTecnico() != null) entity.setDiagnosticoTecnico(dto.getDiagnosticoTecnico());
        if (dto.getObservaciones() != null) entity.setObservaciones(dto.getObservaciones());
        return entity;
    }
}