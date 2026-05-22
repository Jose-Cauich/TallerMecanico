package TallerMecanico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "paquetes_servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaqueteServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paquete")
    private Long idPaquete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mecanico", nullable = false)
    private MecanicoEntity mecanico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo")
    private VehiculoEntity vehiculo;

    @Column(name = "nombre_paquete", columnDefinition = "text")
    private String nombrePaquete;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "precio_paquete", precision = 10, scale = 2)
    private BigDecimal precioPaquete;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @OneToMany(mappedBy = "paquete", cascade = CascadeType.ALL)
    private List<DetallesServicioEntity> detalles;
}