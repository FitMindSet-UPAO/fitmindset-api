package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "Seguimiento")
public class Seguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_SeguimientoID")
    private Long id;

    @Column(name = "Fecha", nullable = true)
    private LocalDateTime fecha;

    @Column(name = "Porcentaje", nullable = true)
    private Integer porcentaje;


    @ManyToOne
    @JoinColumn(name = "FK_MetaID", nullable = false)
    private Meta meta;
}
