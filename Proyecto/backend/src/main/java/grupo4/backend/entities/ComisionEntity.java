package grupo4.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "comisionType")
@Table(name = "comision")
@Data
public abstract class ComisionEntity {
    @Id
    @SequenceGenerator(
            name = "comision_sequence",
            sequenceName = "comision_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comision_sequence"
    )
    protected Integer id_comision;
    protected Integer id_academico_1;
    protected Integer id_academico_2;
    protected Integer id_academico_3;
}
