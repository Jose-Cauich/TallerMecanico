package TallerMecanico.dtos.HistorialMantenimiento;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HistorialMantenimientoPostDTO {
    private Long idVehiculo;
    private Long idMecanico;
    private String diagnosticoTecnico;
    private String trabajoRealizado;
    private String observaciones;
    private String refaccionesCambiadas;
}