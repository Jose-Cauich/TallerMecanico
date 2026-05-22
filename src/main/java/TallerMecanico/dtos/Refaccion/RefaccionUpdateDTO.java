package TallerMecanico.dtos.Refaccion;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RefaccionUpdateDTO {
    private String nombre;
    private String marca;
    private String numeroParte;
    private BigDecimal precioUnitario;
    private Integer stock;
    private Boolean disponible;
}