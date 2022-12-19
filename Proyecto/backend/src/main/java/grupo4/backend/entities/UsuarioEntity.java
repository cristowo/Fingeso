package grupo4.backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "userType")
@Table(name = "usuarios")
@Data

/*
 * Clase Abstracta : UsuarioEntity
 * Descripcion : Clase que representa a un usuario
 */
public abstract class UsuarioEntity {
    @Id

    //atributos de la clase
    protected Integer id_user;
    protected String nombre;
    protected String correo;
    protected String clave;
}
