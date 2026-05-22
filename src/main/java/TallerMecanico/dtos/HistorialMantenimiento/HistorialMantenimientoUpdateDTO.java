package TallerMecanico.dtos.HistorialMantenimiento;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HistorialMantenimientoUpdateDTO {
    private String diagnosticoTecnico;
    private String trabajoRealizado;
    private String observaciones;
    private String refaccionesCambiadas;
}