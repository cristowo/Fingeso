package grupo4.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "comision_evaluacion")
@Data

/*
 * Clase : ComisionEvaluacionEntity
 * Descripcion : Clase que representa a una comision de evaluacion, hereda de ComisionEntity
 */
public class ComisionEvaluacionEntity extends ComisionEntity {
    //Atributos de la clase
    private String departamento;

    //Constructor
    public ComisionEvaluacionEntity(String departamento){
        this.departamento = departamento;
    }
    //Constructor default
    public ComisionEvaluacionEntity(){

    }
}
