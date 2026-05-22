package TallerMecanico.dtos;

import lombok.Data;

@Data
public class CambioPasswordDTO {

    private String passwordActual;
    private String passwordNueva;
    private String confirmacionPassword;

}
