package TallerMecanico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago", nullable = false)
    private PagosEntity pago;

    @Column(name = "rfc", length = 13, nullable = false)
    private String rfc;

    @Column(name = "razon_social", columnDefinition = "text", nullable = false)
    private String razonSocial;

    @Column(name = "uso_cfdi", columnDefinition = "text")
    private String usoCfdi;

    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision;

    @Column(name = "folio_fiscal", columnDefinition = "text", unique = true)
    private String folioFiscal;

    @Column(name = "total", precision = 10, scale = 2, nullable = false)
    private BigDecimal total;
}