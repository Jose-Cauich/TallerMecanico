package TallerMecanico.dtos.Cliente;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import lombok.Data;

@Data
public class ClienteUpdateDTO {

    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String correo;
    private boolean activo;
    private DireccionDTO direccion;

}
