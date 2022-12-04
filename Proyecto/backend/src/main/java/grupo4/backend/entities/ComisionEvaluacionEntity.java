package grupo4.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "comision_evaluacion")
@Data
public class ComisionEvaluacionEntity extends ComisionEntity {
    private String departamento;

    public ComisionEvaluacionEntity(String departamento){
        this.departamento = departamento;
    }

    public ComisionEvaluacionEntity(){

    }
}
