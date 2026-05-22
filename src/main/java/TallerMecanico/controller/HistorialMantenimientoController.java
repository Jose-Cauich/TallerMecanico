package TallerMecanico.controller;

import TallerMecanico.dtos.HistorialMantenimiento.HistorialMantenimientoGetDTO;
import TallerMecanico.dtos.HistorialMantenimiento.HistorialMantenimientoPostDTO;
import TallerMecanico.dtos.HistorialMantenimiento.HistorialMantenimientoUpdateDTO;
import TallerMecanico.service.HistorialMantenimientoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/historial-mantenimiento")
public class HistorialMantenimientoController {

    private final HistorialMantenimientoServicio historialServicio;

    @GetMapping
    public ResponseEntity<List<HistorialMantenimientoGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(historialServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialMantenimientoGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(historialServicio.obtenerPorId(id));
    }

    @GetMapping("/vehiculo/{id}")
    public ResponseEntity<List<HistorialMantenimientoGetDTO>> obtenerPorVehiculo(@PathVariable Long id) {
        return ResponseEntity.ok(historialServicio.obtenerPorVehiculo(id));
    }

    @PostMapping
    public ResponseEntity<HistorialMantenimientoGetDTO> insertarHistorial(@RequestBody HistorialMantenimientoPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(historialServicio.insertarHistorial(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarHistorial(@PathVariable Long id, @RequestBody HistorialMantenimientoUpdateDTO dto) {
        historialServicio.actualizarHistorial(id, dto);
        return ResponseEntity.ok().build();
    }
}