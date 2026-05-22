package TallerMecanico.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "mecanicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MecanicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mecanico")
    private Long idMecanico;

    @Column(name = "nombres", nullable = false, columnDefinition = "text")
    private String nombres;

    @Column(name = "apellido_paterno", nullable = false, columnDefinition = "text")
    private String apellidoPaterno;

    @Column(name = "apellido_materno", columnDefinition = "text")
    private String apellidoMaterno;

    @Column(name = "especialidad", columnDefinition = "text")
    private String especialidad;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "correo", unique = true, columnDefinition = "text")
    private String correo;

    @Column(name = "password_hash", columnDefinition = "text")
    private String passwordHash;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion")
    private DireccionesEntity direccion;

    @CreationTimestamp
    @Column(name = "fecha_register", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @OneToMany(mappedBy = "mecanico")
    private List<HorarioMecanicoEntity> horarios;

    @OneToMany(mappedBy = "mecanico")
    private List<OrdenServicioEntity> ordenes;
}