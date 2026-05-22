package TallerMecanico.dtos.Cliente;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import TallerMecanico.enums.Genero;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClienteRegisterDTO {
    private Long idCliente;
    private Long idMecanico;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String correo;
    private String passwordHash;
    private LocalDateTime fechaRegistro;
    private boolean activo;

    private DireccionDTO direccion;

}