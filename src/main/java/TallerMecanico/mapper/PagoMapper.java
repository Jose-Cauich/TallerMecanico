package TallerMecanico.mapper;

import TallerMecanico.dtos.Pago.PagoGetDTO;
import TallerMecanico.dtos.Pago.PagoPostDTO;
import TallerMecanico.dtos.Pago.PagoUpdateDTO;
import TallerMecanico.entity.ClienteEntity;
import TallerMecanico.entity.OrdenServicioEntity;
import TallerMecanico.entity.PagosEntity;
import TallerMecanico.enums.EstadoPago;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PagoMapper {

    public static PagoGetDTO toDto(PagosEntity entity) {
        if (entity == null) return null;

        PagoGetDTO dto = new PagoGetDTO();

        dto.setIdPago(entity.getIdPago());
        dto.setIdCliente(entity.getCliente().getIdCliente());
        dto.setIdOrdenServicio(entity.getOrdenServicio().getIdOrdenServicio());
        dto.setMonto(entity.getMonto());
        dto.setMoneda(entity.getMoneda());
        dto.setEstadoPago(entity.getEstadoPago().name());
        dto.setStripeReference(entity.getStripeReference());
        dto.setFechaPago(entity.getFechaPago());
        dto.setMetodoPago(entity.getMetodoPago());

        return dto;
    }

    public static PagosEntity toEntity(PagoPostDTO dto, ClienteEntity cliente, OrdenServicioEntity ordenServicio) {
        if (dto == null) return null;

        PagosEntity entity = new PagosEntity();

        entity.setCliente(cliente);
        entity.setOrdenServicio(ordenServicio);
        entity.setMonto(dto.getMonto());
        entity.setMoneda(dto.getMoneda());
        entity.setEstadoPago(EstadoPago.PENDIENTE);
        entity.setFechaPago(dto.getFechaPago());
        entity.setMetodoPago(dto.getMetodoPago());

        return entity;
    }

    public static PagosEntity updateEntity(PagoUpdateDTO dto, PagosEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getMonto() != null) entity.setMonto(dto.getMonto());
        if (dto.getMoneda() != null) entity.setMoneda(dto.getMoneda());
        if (dto.getEstadoPago() != null) entity.setEstadoPago(EstadoPago.valueOf(dto.getEstadoPago()));
        if (dto.getFechaPago() != null) entity.setFechaPago(dto.getFechaPago());
        if (dto.getMetodoPago() != null) entity.setMetodoPago(dto.getMetodoPago());

        return entity;
    }
}