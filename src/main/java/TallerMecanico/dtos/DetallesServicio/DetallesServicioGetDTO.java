package TallerMecanico.dtos.DetallesServicio;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetallesServicioGetDTO {
    private Long idDetalle;
    private Long idOrdenServicio;
    private Long idPaquete;
    private Long idRefaccion;
    private String tipoTrabajo;
    private String cantidad;
    private BigDecimal precioUnitario;
}