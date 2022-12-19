package grupo4.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "comisionType")
@Table(name = "comision")
@Data
/*
 * Clase Abstracta : ComisionEntity ()
 * Descripcion : Clase que representa a una comision de cualquier tipo
 */

public abstract class ComisionEntity {
        //Generacion de id automatico
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

        //Atributos de la clase

    protected Integer id_comision;
    
    //Id de los academicos que pertenecen a la comision
    protected Integer id_academico_1;
    protected Integer id_academico_2;
    protected Integer id_academico_3;
}
