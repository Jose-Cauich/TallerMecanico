package TallerMecanico.dtos.Vehiculo;

import TallerMecanico.dtos.Direccion.DireccionDTO;
import TallerMecanico.enums.Genero;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VehiculoGetDTO {
    private Long idVehiculo;
    private String placa;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private Long idCliente;
    private String nombreDueno;
    private boolean activo;
}