package TallerMecanico.dtos.OrdenServicio;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class OrdenServicioPostDTO {
    private Long idCliente;
    private Long idVehiculo;
    private Long idMecanico;
    private Long idTipoServicio;
    private LocalDate fechaIngreso;
    private LocalTime horaEntrada;
    private LocalTime horaSalidaEstimada;
    private String fallaReportada;
    private String estadoOrden;
}
