package TallerMecanico.dtos.Mecanico;
import TallerMecanico.dtos.Direccion.DireccionDTO;
import TallerMecanico.enums.Genero;
import lombok.Data;
import java.time.LocalDate;

@Data
public class MecanicoRegisterDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String especialidad;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String correo;
    private String password;
    private DireccionDTO direccion;
}