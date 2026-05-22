package TallerMecanico.entity;

import TallerMecanico.enums.NombreRol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleados")
public class EmpleadosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long idEmpleado;

    @Column(name = "nombres", nullable = false, columnDefinition = "text")
    private String nombres;

    @Column(name = "apellido_paterno", nullable = false, columnDefinition = "text")
    private String apellidoPaterno;

    @Column(name = "apellido_materno", columnDefinition = "text")
    private String apellidoMaterno;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "correo", unique = true, columnDefinition = "text")
    private String correo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion")
    private DireccionesEntity direccion;

    @Column(name = "password_hash", columnDefinition = "text")
    private String passwordHash;

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private NombreRol rol;
}