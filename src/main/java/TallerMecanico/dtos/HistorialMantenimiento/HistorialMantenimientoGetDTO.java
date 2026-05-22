package TallerMecanico.dtos.HistorialMantenimiento;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class HistorialMantenimientoGetDTO {
    private Long idHistorial;
    private Long idVehiculo;
    private String placaVehiculo;
    private Long idMecanico;
    private String nombreMecanico;
    private LocalDateTime fechaServicio;
    private String diagnosticoTecnico;
    private String trabajoRealizado;
    private String observaciones;
    private String refaccionesCambiadas;
}