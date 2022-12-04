package grupo4.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "academicos")
@Data
public class AcademicoEntity extends UsuarioEntity{
    private String departamento;
    private String jerarquia;
    private String facultad;
    //comision asiganada a evaluar
    private Integer comision_evaluadora;




}
