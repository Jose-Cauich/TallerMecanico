package TallerMecanico.controller;

import TallerMecanico.dtos.Factura.FacturaGetDTO;
import TallerMecanico.dtos.Factura.FacturaPostDTO;
import TallerMecanico.service.FacturaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/facturas")
public class FacturaController {

    private final FacturaServicio facturaServicio;

    @GetMapping
    public ResponseEntity<List<FacturaGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(facturaServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(facturaServicio.obtenerPorId(id));
    }

    @GetMapping("/pago/{idPago}")
    public ResponseEntity<FacturaGetDTO> obtenerPorPago(@PathVariable Long idPago) {
        return ResponseEntity.ok(facturaServicio.obtenerPorPago(idPago));
    }

    @PostMapping("/{idPago}")
    public ResponseEntity<FacturaGetDTO> insertarFactura(@PathVariable Long idPago, @RequestBody FacturaPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaServicio.insertarFactura(dto, idPago));
    }
}