package TallerMecanico.dtos.OrdenServicio;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class OrdenServicioPutDTO {
    private LocalTime horaEntrada;
    private LocalTime horaSalidaEstimada;
    private String estadoOrden;
    private LocalDate fechaIngreso;
    private String fallaReportada;
}