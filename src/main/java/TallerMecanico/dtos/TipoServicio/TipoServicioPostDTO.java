package TallerMecanico.dtos.TipoServicio;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TipoServicioPostDTO {
    private String nombreServicio;
    private String descripcion;
    private BigDecimal precioBase;
    private Boolean activo;
}