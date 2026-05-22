package TallerMecanico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_mantenimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialMantenimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long idHistorial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private VehiculoEntity vehiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mecanico", nullable = false)
    private MecanicoEntity mecanico;

    @Column(name = "diagnostico_tecnico", columnDefinition = "text")
    private String diagnosticoTecnico;

    @Column(name = "trabajo_realizado", columnDefinition = "text")
    private String trabajoRealizado;

    @Column(name = "observaciones", columnDefinition = "text")
    private String observaciones;

    @Column(name = "fecha_servicio")
    private LocalDateTime fechaServicio;

    @Column(name = "refacciones_cambiadas", columnDefinition = "text")
    private String refaccionesCambiadas; // Piezas nuevas instaladas
}