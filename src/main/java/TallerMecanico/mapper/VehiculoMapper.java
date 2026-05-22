package TallerMecanico.mapper;

import TallerMecanico.dtos.Vehiculo.VehiculoGetDTO;
import TallerMecanico.dtos.Vehiculo.VehiculoPostDTO;
import TallerMecanico.dtos.Vehiculo.VehiculoUpdateDTO;
import TallerMecanico.entity.ClienteEntity;
import TallerMecanico.entity.VehiculoEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VehiculoMapper {

    public static VehiculoGetDTO toDto(VehiculoEntity entity) {
        if (entity == null) return null;

        VehiculoGetDTO dto = new VehiculoGetDTO();

        dto.setIdVehiculo(entity.getIdVehiculo());
        dto.setIdCliente(entity.getCliente().getIdCliente());
        dto.setPlaca(entity.getPlaca());
        dto.setMarca(entity.getMarca());
        dto.setModelo(entity.getModelo());
        dto.setAnio(entity.getAnio());
        dto.setColor(entity.getColor());

        return dto;
    }

    public static VehiculoEntity toEntity(VehiculoPostDTO dto, ClienteEntity cliente) {
        if (dto == null) return null;

        VehiculoEntity entity = new VehiculoEntity();

        entity.setCliente(cliente);
        entity.setPlaca(dto.getPlaca());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());
        entity.setAnio(dto.getAnio());
        entity.setColor(dto.getColor());

        return entity;
    }

    public static VehiculoEntity updateEntity(VehiculoUpdateDTO dto, VehiculoEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getPlaca() != null) entity.setPlaca(dto.getPlaca());
        if (dto.getMarca() != null) entity.setMarca(dto.getMarca());
        if (dto.getModelo() != null) entity.setModelo(dto.getModelo());
        if (dto.getAnio() != 0) entity.setAnio(dto.getAnio());
        if (dto.getColor() != null) entity.setColor(dto.getColor());
        if (dto.getActivo() != null) entity.setActivo(dto.getActivo());

        return entity;
    }
}