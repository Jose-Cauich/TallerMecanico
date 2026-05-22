package TallerMecanico.controller;

import TallerMecanico.dtos.TipoServicio.TipoServicioGetDTO;
import TallerMecanico.service.TipoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipos-servicio")
public class TipoServicioController {

    private final TipoServicio tipoServicio;

    @GetMapping
    public ResponseEntity<List<TipoServicioGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(tipoServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoServicioGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoServicio.obtenerPorId(id));
    }
}
