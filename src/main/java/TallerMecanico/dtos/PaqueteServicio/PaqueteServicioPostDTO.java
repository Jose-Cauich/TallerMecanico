package TallerMecanico.dtos.PaqueteServicio;

import TallerMecanico.dtos.DetallesServicio.DetallesServicioPostDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class PaqueteServicioPostDTO {
    private Long idMecanico;
    private Long idVehiculo;
    private String nombrePaquete;
    private String descripcion;
    private BigDecimal precioPaquete;
    private List<DetallesServicioPostDTO> detalles;
}