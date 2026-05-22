package TallerMecanico.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direcciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long idDireccion;

    @Column(name = "calle", columnDefinition = "text")
    private String calle;

    @Column(name = "colonia", columnDefinition = "text")
    private String colonia;

    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;

    @Column(name = "estado", columnDefinition = "text")
    private String estado;

    @Column(name = "municipio", columnDefinition = "text")
    private String municipio;
}
