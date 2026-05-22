package TallerMecanico.dtos.Direccion;

import lombok.Data;

@Data
public class DireccionDTO {
    private Long idDireccion;
    private String calle;
    private String colonia;
    private String codigoPostal;
    private String estado;
    private String municipio;
}