package TallerMecanico.mapper;

import TallerMecanico.dtos.PaqueteServicio.PaqueteServicioGetDTO;
import TallerMecanico.dtos.PaqueteServicio.PaqueteServicioPostDTO;
import TallerMecanico.dtos.PaqueteServicio.PaqueteServicioUpdateDTO;
import TallerMecanico.entity.MecanicoEntity;
import TallerMecanico.entity.PaqueteServicioEntity;
import TallerMecanico.entity.VehiculoEntity;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class PaqueteServicioMapper {

    public static PaqueteServicioGetDTO toDto(PaqueteServicioEntity entity) {
        if (entity == null) return null;

        PaqueteServicioGetDTO dto = new PaqueteServicioGetDTO();
        dto.setIdPaquete(entity.getIdPaquete());
        dto.setIdVehiculo(entity.getVehiculo().getIdVehiculo());
        dto.setIdMecanico(entity.getMecanico().getIdMecanico());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setActivo(entity.isActivo());
        dto.setNombrePaquete(entity.getNombrePaquete());
        dto.setPrecioPaquete(entity.getPrecioPaquete());

        return dto;
    }

    public static PaqueteServicioEntity toEntity(PaqueteServicioPostDTO dto, VehiculoEntity vehiculo, MecanicoEntity mecanico) {
        if (dto == null) return null;

        PaqueteServicioEntity entity = new PaqueteServicioEntity();
        entity.setVehiculo(vehiculo);
        entity.setMecanico(mecanico);
        entity.setFechaCreacion(LocalDate.now());
        entity.setNombrePaquete(dto.getNombrePaquete());
        entity.setPrecioPaquete(dto.getPrecioPaquete());

        return entity;
    }

    public static PaqueteServicioEntity updateEntity(PaqueteServicioUpdateDTO dto, PaqueteServicioEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getActivo() != null) entity.setActivo(dto.getActivo());
        if (dto.getNombrePaquete() != null) entity.setNombrePaquete(dto.getNombrePaquete());
        if (dto.getPrecioPaquete() != null) entity.setPrecioPaquete(dto.getPrecioPaquete());

        return entity;
    }
}