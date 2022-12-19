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

/*
 * Clase : AcademicoEntity
 * Descripcion : Clase que representa a un academico el cual es un tipo de usuario 
 */

public class AcademicoEntity extends UsuarioEntity{
    //Atributos de la clase
    //Nombre de departamento al que pertenece
    private String departamento;
    //Nivel de jerarquia del academico
    private String jerarquia;
    //Facultad a la que pertenece
    private String facultad;
    //comision asiganada a evaluar
    private Integer comision_evaluadora;




}
