package TallerMecanico.entity;

import TallerMecanico.enums.EstadoOrden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ordenes_servicio")
public class OrdenServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_servicio")
    private Long idOrdenServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private VehiculoEntity vehiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mecanico", nullable = false)
    private MecanicoEntity mecanico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_servicio", nullable = false)
    private TipoServicioEntity tipoServicio;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada;

    @Column(name = "hora_salida_estimada")
    private LocalTime horaSalidaEstimada;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_orden", nullable = false)
    private EstadoOrden estadoOrden;

    @Column(name = "falla_reportada", columnDefinition = "text")
    private String fallaReportada;
}