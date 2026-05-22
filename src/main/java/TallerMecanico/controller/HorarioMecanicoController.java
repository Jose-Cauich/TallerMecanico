package TallerMecanico.controller;

import TallerMecanico.dtos.HorarioMecanico.HorarioMecanicoGetDTO;
import TallerMecanico.dtos.HorarioMecanico.HorarioMecanicoPostDTO;
import TallerMecanico.dtos.HorarioMecanico.HorarioMecanicoUpdateDTO;
import TallerMecanico.service.HorarioMecanicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/horarios")
public class HorarioMecanicoController {

    private final HorarioMecanicoServicio horarioServicio;

    @GetMapping
    public ResponseEntity<List<HorarioMecanicoGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(horarioServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioMecanicoGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(horarioServicio.obtenerPorId(id));
    }

    @GetMapping("/mecanico/{idMecanico}")
    public ResponseEntity<List<HorarioMecanicoGetDTO>> obtenerPorMecanico(@PathVariable Long idMecanico) {
        return ResponseEntity.ok(horarioServicio.obtenerPorMecanico(idMecanico));
    }

    @PostMapping
    public ResponseEntity<HorarioMecanicoGetDTO> insertarHorario(@RequestBody HorarioMecanicoPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioServicio.insertarHorario(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarHorario(@PathVariable Long id, @RequestBody HorarioMecanicoUpdateDTO dto) {
        horarioServicio.actualizarHorario(id, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarHorario(@PathVariable Long id) {
        horarioServicio.desactivarHorario(id);
        return ResponseEntity.ok().build();
    }
}