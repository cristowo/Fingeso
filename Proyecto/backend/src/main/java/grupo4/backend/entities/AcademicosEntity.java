package grupo4.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "academicos")
@NoArgsConstructor
@AllArgsConstructor
//geters and seters
@Data
public class AcademicosEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(unique = true, nullable = false)
    private Integer Id;
    private String Name;
    private String Email;
    private Integer Rol;
    private String Contraseña;
    private String departamento;
    private Integer id_comision_evaluadora;
}
