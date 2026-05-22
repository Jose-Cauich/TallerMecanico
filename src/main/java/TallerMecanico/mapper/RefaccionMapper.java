package TallerMecanico.mapper;

import TallerMecanico.dtos.Refaccion.RefaccionGetDTO;
import TallerMecanico.dtos.Refaccion.RefaccionPostDTO;
import TallerMecanico.dtos.Refaccion.RefaccionUpdateDTO;
import TallerMecanico.entity.RefaccionEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RefaccionMapper {

    public static RefaccionGetDTO toDto(RefaccionEntity entity) {
        if (entity == null) return null;

        RefaccionGetDTO dto = new RefaccionGetDTO();

        dto.setIdRefaccion(entity.getIdRefaccion());
        dto.setNombre(entity.getNombre());
        dto.setMarca(entity.getMarca());
        dto.setNumeroParte(entity.getNumeroParte());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        dto.setStock(entity.getStock());
        return dto;
    }

    public static RefaccionEntity toEntity(RefaccionPostDTO dto) {
        if (dto == null) return null;

        RefaccionEntity entity = new RefaccionEntity();

        entity.setNombre(dto.getNombre());
        entity.setMarca(dto.getMarca());
        entity.setNumeroParte(dto.getNumeroParte());
        entity.setPrecioUnitario(dto.getPrecioUnitario());
        entity.setStock(dto.getStock());
        return entity;
    }

    public static RefaccionEntity updateEntity(RefaccionUpdateDTO dto, RefaccionEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getNombre() != null) entity.setNombre(dto.getNombre());
        if (dto.getMarca() != null) entity.setMarca(dto.getMarca());
        if (dto.getNumeroParte() != null) entity.setNumeroParte(dto.getNumeroParte());
        if (dto.getPrecioUnitario() != null) entity.setPrecioUnitario(dto.getPrecioUnitario());
        if (dto.getStock() != null) entity.setStock(dto.getStock());
        if (dto.getDisponible() != null) entity.setDisponible(dto.getDisponible());

        return entity;
    }
}
