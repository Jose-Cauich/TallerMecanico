package TallerMecanico.dtos.PaqueteServicio;

import TallerMecanico.dtos.DetallesServicio.DetallesServicioGetDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PaqueteServicioGetDTO {
    private Long idPaquete;
    private Long idMecanico;
    private String nombreMecanico;
    private Long idVehiculo;
    private String nombrePaquete;
    private String descripcion;
    private BigDecimal precioPaquete;
    private LocalDate fechaCreacion;
    private Boolean activo;
    private List<DetallesServicioGetDTO> detalles;
}
