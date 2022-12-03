package grupo4.backend.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import grupo4.backend.entities.AcademicosEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comision")
//geters and seters
@Data
public class ComisionEntity {
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
    private Integer id_comision;
    private Integer rut_academico1;
    private Integer rut_academico2;
    private Integer rut_academico3;
    private String departamento;

    public ComisionEntity(Integer academico1, Integer academico2, Integer academico3, String departamento){
        this.rut_academico1 = academico1;
        this.rut_academico2 = academico2;
        this.rut_academico3 = academico3;
        this.departamento = departamento;
    }

    public ComisionEntity(){

    }
}
