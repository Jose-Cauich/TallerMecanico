package TallerMecanico.dtos.HorarioMecanico;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HorarioMecanicoPostDTO {
    private Long idMecanico;
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}