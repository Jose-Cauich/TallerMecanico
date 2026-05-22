package TallerMecanico.dtos.Pago;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PagoGetDTO {
    private Long idPago;
    private Long idCliente;
    private Long idOrdenServicio;
    private BigDecimal monto;
    private String moneda;
    private String estadoPago;
    private String stripeReference;
    private LocalDateTime fechaPago;
    private String metodoPago;
}