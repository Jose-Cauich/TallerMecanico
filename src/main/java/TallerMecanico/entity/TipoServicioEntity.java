package TallerMecanico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tipos_servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_servicio")
    private Long idTipoServicio;

    @Column(name = "nombre_servicio", columnDefinition = "text", nullable = false)
    private String nombreServicio;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "precio_base", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioBase;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;
}