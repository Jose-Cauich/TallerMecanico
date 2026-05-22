package TallerMecanico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    // Relación con el mecánico principal asignado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mecanico", nullable = false)
    private MecanicoEntity mecanico;

    @Column(name = "nombres", nullable = false, columnDefinition = "text")
    private String nombres;

    @Column(name = "apellido_paterno", nullable = false, columnDefinition = "text")
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, columnDefinition = "text")
    private String apellidoMaterno;

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "correo", nullable = false, unique = true, columnDefinition = "text")
    private String correo;

    @Column(name = "password_hash", columnDefinition = "text")
    private String passwordHash;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion")
    private DireccionesEntity direccion;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<VehiculoEntity> vehiculos;
}