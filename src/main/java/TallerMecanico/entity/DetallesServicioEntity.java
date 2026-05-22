package TallerMecanico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "detalles_servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallesServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paquete")
    private PaqueteServicioEntity paquete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_servicio")
    private OrdenServicioEntity ordenServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_refaccion")
    private RefaccionEntity refaccion;

    @Column(name = "tipo_trabajo", columnDefinition = "text")
    private String tipoTrabajo;

    @Column(name = "cantidad", columnDefinition = "text")
    private String cantidad;

    @Column(name = "precio_unitario_aplicado")
    private BigDecimal precioUnitario;
}