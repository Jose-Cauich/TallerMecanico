package TallerMecanico.dtos.Factura;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FacturaPostDTO {
    private Long idPago;
    private String rfc;
    private String razonSocial;
    private String usoCfdi;
    private LocalDateTime fechaEmision;
    private String folioFiscal;
    private BigDecimal total;
}