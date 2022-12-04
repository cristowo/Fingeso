package grupo4.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "userType")
@Table(name = "usuarios")
@Data
public abstract class UsuarioEntity {
    @Id
    protected Integer id_user;
    protected String nombre;
    protected String correo;
    protected String clave;
}
