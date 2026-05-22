package TallerMecanico.dtos.HorarioMecanico;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HorarioMecanicoUpdateDTO {
    private Long idHorario;
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Boolean Activo;
}