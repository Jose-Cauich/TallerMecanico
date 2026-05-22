package TallerMecanico.controller;

import TallerMecanico.dtos.Refaccion.RefaccionGetDTO;
import TallerMecanico.dtos.Refaccion.RefaccionPostDTO;
import TallerMecanico.dtos.Refaccion.RefaccionUpdateDTO;
import TallerMecanico.service.RefaccionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/refacciones")
public class RefaccionController {

    private final RefaccionServicio refaccionServicio;

    @GetMapping
    public ResponseEntity<List<RefaccionGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(refaccionServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RefaccionGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(refaccionServicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<RefaccionGetDTO> insertarRefaccion(@RequestBody RefaccionPostDTO refaccionPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(refaccionServicio.insertarRefaccion(refaccionPostDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarRefaccion(@PathVariable Long id, @RequestBody RefaccionUpdateDTO dto) {
        refaccionServicio.actualizarRefaccion(id, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarRefaccion(@PathVariable Long id) {
        refaccionServicio.desactivarRefaccion(id);
        return ResponseEntity.ok().build();
    }
}