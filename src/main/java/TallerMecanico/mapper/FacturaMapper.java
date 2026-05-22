package TallerMecanico.mapper;

import TallerMecanico.dtos.Factura.FacturaGetDTO;
import TallerMecanico.dtos.Factura.FacturaPostDTO;
import TallerMecanico.entity.FacturasEntity;
import TallerMecanico.entity.PagosEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FacturaMapper {

    public static FacturaGetDTO toDto(FacturasEntity entity) {
        if (entity == null) return null;

        FacturaGetDTO dto = new FacturaGetDTO();

        dto.setIdFactura(entity.getIdFactura());
        dto.setIdPago(entity.getPago().getIdPago());
        dto.setRfc(entity.getRfc());
        dto.setRazonSocial(entity.getRazonSocial());
        dto.setUsoCfdi(entity.getUsoCfdi());
        dto.setFechaEmision(entity.getFechaEmision());
        dto.setFolioFiscal(entity.getFolioFiscal());
        dto.setTotal(entity.getTotal());

        return dto;
    }

    public static FacturasEntity toEntity(FacturaPostDTO dto, PagosEntity pago) {
        if (dto == null) return null;

       FacturasEntity entity = new FacturasEntity();

        entity.setPago(pago);
        entity.setRfc(dto.getRfc());
        entity.setRazonSocial(dto.getRazonSocial());
        entity.setUsoCfdi(dto.getUsoCfdi());
        entity.setFechaEmision(dto.getFechaEmision());
        entity.setFolioFiscal(dto.getFolioFiscal());
        entity.setTotal(dto.getTotal());

        return entity;
    }
}
