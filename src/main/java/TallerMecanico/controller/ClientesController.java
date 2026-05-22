package TallerMecanico.controller;

import TallerMecanico.dtos.Cliente.ClienteRegisterDTO;
import TallerMecanico.dtos.Cliente.ClienteResponseDTO;
import TallerMecanico.dtos.Cliente.ClienteUpdateDTO;
import TallerMecanico.service.ClienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClientesController {

    private final ClienteServicio clienteServicio;

    @GetMapping("/todos")
    public ResponseEntity<List<ClienteResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(clienteServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtenerCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteServicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> insertarCliente(@RequestBody ClienteRegisterDTO clienteRegisterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteServicio.insertarCliente(clienteRegisterDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarCliente(@PathVariable Long id, @RequestBody ClienteUpdateDTO clienteUpdateDTO) {
        clienteServicio.actualizarCliente(id, clienteUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/desactivar/{id}")
    public ResponseEntity<Void> desactivarCliente(@PathVariable Long id) {
        clienteServicio.desactivarCliente(id);
        return ResponseEntity.ok().build();
    }
}
