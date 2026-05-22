package TallerMecanico.dtos.OrdenServicio;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class OrdenServicioGetDTO {
    private Long idOrdenServicio;
    private String nombreCliente;
    private String placaVehiculo;
    private String nombreMecanico;
    private String nombreTipoServicio;
    private LocalDate fechaIngreso;
    private LocalTime horaEntrada;
    private LocalTime horaSalidaEstimada;
    private String estadoOrden;
    private String fallaReportada;
}