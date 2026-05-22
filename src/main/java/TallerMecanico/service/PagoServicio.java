package TallerMecanico.service;

import TallerMecanico.dtos.Pago.PagoGetDTO;
import TallerMecanico.dtos.Pago.PagoPostDTO;
import TallerMecanico.entity.*;
import TallerMecanico.mapper.PagoMapper;
import TallerMecanico.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PagoServicio {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public PagoGetDTO obtenerPorId(Long idPago) {
        PagosEntity pago = pagoRepository.findById(idPago).orElseThrow(() -> new IllegalArgumentException("El pago no existe"));
        return PagoMapper.toDto(pago);
    }

    public PagoGetDTO insertarPago(PagoPostDTO dto) {

        ClienteEntity cliente = clienteRepository.findById(dto.getIdCliente()).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        OrdenServicioEntity orden = ordenServicioRepository.findById(dto.getIdOrdenServicio()).orElseThrow(() -> new RuntimeException("No se encontró la orden de servicio"));
        PagosEntity nuevoPago = PagoMapper.toEntity(dto, cliente, orden);

        log.info("Pago registrado con éxito para la orden ID: {}", orden.getIdOrdenServicio());
        return PagoMapper.toDto(pagoRepository.save(nuevoPago));
    }
}
