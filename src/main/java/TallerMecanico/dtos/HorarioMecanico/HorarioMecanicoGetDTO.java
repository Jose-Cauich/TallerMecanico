package TallerMecanico.dtos.HorarioMecanico;

import lombok.Data;
import java.time.LocalTime;

@Data
public class HorarioMecanicoGetDTO {
    private Long idMecanico;
    private Long idHorario;
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Boolean Activo;
}