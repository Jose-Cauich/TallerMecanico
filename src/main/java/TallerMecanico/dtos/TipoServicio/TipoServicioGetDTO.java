package TallerMecanico.dtos.TipoServicio;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TipoServicioGetDTO {
    private Long idTipoServicio;
    private String nombreServicio;
    private String descripcion;
    private BigDecimal precioBase;
    private boolean activo;
}