package TallerMecanico.dtos.PaqueteServicio;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PaqueteServicioUpdateDTO {
    private String nombrePaquete;
    private String descripcion;
    private BigDecimal precioPaquete;
    private Boolean activo;
    private Long idVehiculo;
}