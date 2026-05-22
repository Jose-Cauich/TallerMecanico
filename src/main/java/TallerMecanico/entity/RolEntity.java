package TallerMecanico.entity;

import TallerMecanico.enums.NombreRol;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre", nullable = false, columnDefinition = "text")
    private NombreRol nombreRol;

}