package TallerMecanico.dtos.Pago;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PagoPostDTO {
    private Long idCliente;
    private Long idOrdenServicio;
    private BigDecimal monto;
    private String moneda;
    private String estadoPago;
    private LocalDateTime fechaPago;
    private String metodoPago;
}