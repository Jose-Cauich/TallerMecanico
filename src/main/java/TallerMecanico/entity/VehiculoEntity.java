package TallerMecanico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;

    @Column(name = "placa", nullable = false, unique = true, length = 10)
    private String placa;

    @Column(name = "marca", nullable = false, columnDefinition = "text")
    private String marca;

    @Column(name = "modelo", nullable = false, columnDefinition = "text")
    private String modelo;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "color", columnDefinition = "text")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteEntity cliente;

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<HistorialMantenimientoEntity> historiales;
}