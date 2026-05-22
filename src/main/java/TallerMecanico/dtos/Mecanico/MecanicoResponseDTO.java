package TallerMecanico.dtos.Mecanico;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MecanicoResponseDTO {
    private Long idMecanico;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String especialidad;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String correo;
    private LocalDateTime fechaRegistro;
    private DireccionDTO direccion;
    private boolean activo;
}