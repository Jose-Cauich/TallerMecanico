package TallerMecanico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "refacciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_refaccion")
    private Long idRefaccion;

    @Column(name = "nombre", nullable = false, columnDefinition = "text")
    private String nombre;

    @Column(name = "marca", columnDefinition = "text")
    private String marca;

    @Column(name = "numero_parte", columnDefinition = "text")
    private String numeroParte;

    @Column(name = "precio_unitario", precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "disponible")
    private Boolean disponible = true;
}