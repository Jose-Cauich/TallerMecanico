package TallerMecanico.dtos.Vehiculo;

import lombok.Data;

@Data
public class VehiculoUpdateDTO {
    private String placa;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private Boolean activo;
}