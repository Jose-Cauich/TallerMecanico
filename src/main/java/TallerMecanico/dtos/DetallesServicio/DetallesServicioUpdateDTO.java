package TallerMecanico.dtos.DetallesServicio;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetallesServicioUpdateDTO {
    private String tipoTrabajo;
    private String descripcion;
    private String cantidad;
    private BigDecimal precioUnitario;
}