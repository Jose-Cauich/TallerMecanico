package TallerMecanico.controller;

import TallerMecanico.dtos.Mecanico.MecanicoRegisterDTO;
import TallerMecanico.dtos.Mecanico.MecanicoResponseDTO;
import TallerMecanico.dtos.Mecanico.MecanicoUpdateDTO;
import TallerMecanico.service.MecanicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mecanicos")
public class MecanicoController {

    private final MecanicoServicio mecanicoServicio;

    @GetMapping("/todos")
    public ResponseEntity<List<MecanicoResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(mecanicoServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MecanicoResponseDTO> obtenerMecanico(@PathVariable Long id) {
        return ResponseEntity.ok(mecanicoServicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<MecanicoResponseDTO> insertarMecanico(@RequestBody MecanicoRegisterDTO mecanicoRegisterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mecanicoServicio.insertarMecanico(mecanicoRegisterDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarMecanico(@PathVariable Long id, @RequestBody MecanicoUpdateDTO mecanicoUpdateDTO) {
        mecanicoServicio.actualizarMecanico(id, mecanicoUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/desactivar/{id}")
    public ResponseEntity<Void> desactivarMecanico(@PathVariable Long id) {
        mecanicoServicio.desactivarMecanico(id);
        return ResponseEntity.ok().build();
    }
}