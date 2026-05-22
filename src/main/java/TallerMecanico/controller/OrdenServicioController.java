package TallerMecanico.controller;

import TallerMecanico.dtos.OrdenServicio.OrdenServicioGetDTO;
import TallerMecanico.dtos.OrdenServicio.OrdenServicioPostDTO;
import TallerMecanico.dtos.OrdenServicio.OrdenServicioPutDTO;
import TallerMecanico.service.OrdenServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ordenes-servicio")
public class OrdenServicioController {

    private final OrdenServicio ordenServicio;

    @GetMapping
    public ResponseEntity<List<OrdenServicioGetDTO>> obtenerPorCliente(@RequestParam Long idCliente) {
        return ResponseEntity.ok(ordenServicio.obtenerPorCliente(idCliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenServicioGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ordenServicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<OrdenServicioGetDTO> insertarOrden(@RequestBody OrdenServicioPostDTO ordenServicioPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenServicio.insertarOrden(ordenServicioPostDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarOrden(@PathVariable Long id, @RequestBody OrdenServicioPutDTO ordenServicioPutDTO) {
        ordenServicio.actualizarOrden(id, ordenServicioPutDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Long id) {
        ordenServicio.eliminarOrden(id);
        return ResponseEntity.ok().build();
    }
}
