package TallerMecanico.dtos.Empleados;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EmpleadosResponseDTO {
    private Long idEmpleado;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String correo;
    private String telefono;
    private String rol;
    private LocalDateTime fechaRegistro;
    private DireccionDTO direccion;
    private boolean activo;
}