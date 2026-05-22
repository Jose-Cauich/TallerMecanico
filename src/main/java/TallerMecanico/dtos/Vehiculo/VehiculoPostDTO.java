package TallerMecanico.dtos.Vehiculo;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VehiculoPostDTO {
    private String placa;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private Long idCliente;
}