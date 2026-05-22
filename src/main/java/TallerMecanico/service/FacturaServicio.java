package TallerMecanico.service;

import TallerMecanico.dtos.Factura.FacturaGetDTO;
import TallerMecanico.dtos.Factura.FacturaPostDTO;
import TallerMecanico.entity.FacturasEntity;
import TallerMecanico.entity.PagosEntity;
import TallerMecanico.mapper.FacturaMapper;
import TallerMecanico.repository.FacturaRepository;
import TallerMecanico.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacturaServicio {

    private final FacturaRepository facturaRepository;
    private final PagoRepository pagoRepository;

    public List<FacturaGetDTO> obtenerTodos() {
        return facturaRepository.findAll().stream().map(FacturaMapper::toDto).collect(Collectors.toList());
    }

    public FacturaGetDTO obtenerPorId(Long id) {
        FacturasEntity factura = facturaRepository.findById(id).orElseThrow(() -> new RuntimeException("Factura no encontrada con ID: " + id));
        return FacturaMapper.toDto(factura);
    }

    public FacturaGetDTO obtenerPorPago(Long idPago) {
        FacturasEntity factura = facturaRepository.findByPago_IdPago(idPago).orElseThrow(() -> new RuntimeException("Factura no encontrada para el pago con ID: " + idPago));
        return FacturaMapper.toDto(factura);
    }

    public FacturaGetDTO insertarFactura(FacturaPostDTO dto, Long idPago) {
        PagosEntity pago = pagoRepository.findById(idPago).orElseThrow(() -> new RuntimeException("Pago no encontrado con ID: " + idPago));
        FacturasEntity nuevaFactura = FacturaMapper.toEntity(dto, pago);

        log.info("Factura guardada con éxito");
        return FacturaMapper.toDto(facturaRepository.save(nuevaFactura));
    }
}
