package TallerMecanico.dtos.Cliente;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClienteResponseDTO {

    private Long idCliente;
    private Long idMecanico;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String correo;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaRegistro;
    private boolean activo;
    private DireccionDTO direccion;
}
