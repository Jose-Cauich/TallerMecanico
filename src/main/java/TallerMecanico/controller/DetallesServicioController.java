package TallerMecanico.controller;

import TallerMecanico.dtos.DetallesServicio.DetallesServicioGetDTO;
import TallerMecanico.dtos.DetallesServicio.DetallesServicioPostDTO;
import TallerMecanico.dtos.DetallesServicio.DetallesServicioUpdateDTO;
import TallerMecanico.service.DetallesServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detalles-servicio")
public class DetallesServicioController {

    private final DetallesServicio detallesServicio;

    @GetMapping
    public ResponseEntity<List<DetallesServicioGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(detallesServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallesServicioGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(detallesServicio.obtenerPorId(id));
    }

    @GetMapping("/paquete/{idPaquete}")
    public ResponseEntity<List<DetallesServicioGetDTO>> obtenerPorPaquete(@PathVariable Long idPaquete) {
        return ResponseEntity.ok(detallesServicio.obtenerPorPaquete(idPaquete));
    }

    @PostMapping
    public ResponseEntity<DetallesServicioGetDTO> insertarDetalle(@RequestBody DetallesServicioPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detallesServicio.insertarDetalle(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarDetalle(@PathVariable Long id, @RequestBody DetallesServicioUpdateDTO dto) {
        detallesServicio.actualizarDetalle(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long id) {
        detallesServicio.desactivarDetalle(id);
        return ResponseEntity.ok().build();
    }
}