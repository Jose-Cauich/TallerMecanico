package TallerMecanico.controller;

import TallerMecanico.dtos.PaqueteServicio.PaqueteServicioGetDTO;
import TallerMecanico.dtos.PaqueteServicio.PaqueteServicioPostDTO;
import TallerMecanico.dtos.PaqueteServicio.PaqueteServicioUpdateDTO;
import TallerMecanico.service.PaqueteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paquetes")
public class PaqueteServicioController {

    private final PaqueteServicio paqueteServicio;

    @GetMapping
    public ResponseEntity<List<PaqueteServicioGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(paqueteServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaqueteServicioGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(paqueteServicio.obtenerPorId(id));
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<PaqueteServicioGetDTO>> obtenerPorCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(paqueteServicio.obtenerPorCliente(idCliente));
    }

    @PostMapping
    public ResponseEntity<PaqueteServicioGetDTO> insertarPaquete(@RequestBody PaqueteServicioPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paqueteServicio.insertarPaquete(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarPaquete(@PathVariable Long id, @RequestBody PaqueteServicioUpdateDTO dto) {
        paqueteServicio.actualizarPaquete(id, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarPaquete(@PathVariable Long id) {
        paqueteServicio.desactivarPaquete(id);
        return ResponseEntity.ok().build();
    }
}