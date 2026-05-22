package TallerMecanico.dtos.Mecanico;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import lombok.Data;

@Data
public class MecanicoUpdateDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String especialidad;
    private String telefono;
    private String correo;
    private Boolean activo;
    private DireccionDTO direccion;
}