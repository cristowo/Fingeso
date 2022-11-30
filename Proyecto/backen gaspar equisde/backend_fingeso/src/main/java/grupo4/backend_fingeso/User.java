package grupo4.backend_fingeso;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
@Table(name = "usuario")
@Data
public  abstract class User {
    @Id
    protected String rut;
    protected String name;
    protected String email;
    protected String password;
    protected String role;

}
