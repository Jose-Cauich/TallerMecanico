package TallerMecanico.mapper;

import TallerMecanico.dtos.HorarioMecanico.HorarioMecanicoGetDTO;
import TallerMecanico.dtos.HorarioMecanico.HorarioMecanicoPostDTO;
import TallerMecanico.dtos.HorarioMecanico.HorarioMecanicoUpdateDTO;
import TallerMecanico.entity.HorarioMecanicoEntity;
import TallerMecanico.entity.MecanicoEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HorarioMecanicoMapper {

    public static HorarioMecanicoGetDTO toDto(HorarioMecanicoEntity entity) {
        if (entity == null) return null;

        HorarioMecanicoGetDTO dto = new HorarioMecanicoGetDTO();
        dto.setIdMecanico(entity.getMecanico().getIdMecanico());
        dto.setIdHorario(entity.getIdHorario());
        dto.setDiaSemana(entity.getDiaSemana());
        dto.setHoraInicio(entity.getHoraInicio());
        dto.setHoraFin(entity.getHoraFin());
        dto.setActivo(entity.getActivo());

        return dto;
    }

    public static HorarioMecanicoEntity toEntity(HorarioMecanicoPostDTO dto, MecanicoEntity mecanico) {
        if (dto == null) return null;

        TallerMecanico.entity.HorarioMecanicoEntity entity = new TallerMecanico.entity.HorarioMecanicoEntity();
        entity.setMecanico(mecanico);
        entity.setDiaSemana(dto.getDiaSemana());
        entity.setHoraInicio(dto.getHoraInicio());
        entity.setHoraFin(dto.getHoraFin());
        entity.setActivo(true);

        return entity;
    }

    public static HorarioMecanicoEntity updateEntity(HorarioMecanicoUpdateDTO dto, HorarioMecanicoEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getDiaSemana() != null) entity.setDiaSemana(dto.getDiaSemana());
        if (dto.getHoraInicio() != null) entity.setHoraInicio(dto.getHoraInicio());
        if (dto.getHoraFin() != null) entity.setHoraFin(dto.getHoraFin());
        if (dto.getActivo() != null) entity.setActivo(dto.getActivo());

        return entity;
    }
}