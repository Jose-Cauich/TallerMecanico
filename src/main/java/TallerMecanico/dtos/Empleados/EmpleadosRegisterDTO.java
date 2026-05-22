package TallerMecanico.dtos.Empleados;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EmpleadosRegisterDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String correo;
    private String telefono;
    private String password;
    private String rol;
    private DireccionDTO direccion;
}