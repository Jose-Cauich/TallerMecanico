package TallerMecanico.controller;

import TallerMecanico.dtos.Vehiculo.VehiculoGetDTO;
import TallerMecanico.dtos.Vehiculo.VehiculoPostDTO;
import TallerMecanico.dtos.Vehiculo.VehiculoUpdateDTO;
import TallerMecanico.service.VehiculoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoServicio vehiculoServicio;

    @GetMapping
    public ResponseEntity<List<VehiculoGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(vehiculoServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoServicio.obtenerPorId(id));
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<VehiculoGetDTO>> obtenerPorCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(vehiculoServicio.obtenerPorCliente(idCliente));
    }

    @PostMapping
    public ResponseEntity<VehiculoGetDTO> insertarVehiculo(@RequestBody VehiculoPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoServicio.insertarVehiculo(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarVehiculo(@PathVariable Long id, @RequestBody VehiculoUpdateDTO dto) {
        vehiculoServicio.actualizarVehiculo(id, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarVehiculo(@PathVariable Long id) {
        vehiculoServicio.desactivarVehiculo(id);
        return ResponseEntity.ok().build();
    }
}