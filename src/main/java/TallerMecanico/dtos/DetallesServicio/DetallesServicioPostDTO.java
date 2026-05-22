package TallerMecanico.dtos.DetallesServicio;

import lombok.Data;

@Data
public class DetallesServicioPostDTO {
    private Long idOrdenServicio;
    private Long idRefaccion;
    private Long idPaquete;
    private String tipoTrabajo;
    private String descripcion;
    private String cantidad;
    private Double precioUnitario;
}