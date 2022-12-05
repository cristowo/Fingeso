package grupo4.backend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "compromisos")
@Data
public class CompromisoEntity {
    @Id
    @SequenceGenerator(
            name = "compromiso_sequence",
            sequenceName = "compromiso_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "compromiso_sequence"
    )
    private Integer id_compromiso;
    private String nombre;
    private String tipo_compromiso;
    private String descripcion;
    // hay que evaluar si se cambia este apartado por un archivo
    private String link;
    // puntuacion actual
    private Integer puntuacion;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_inicio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_termino;
    // id del creador del compromiso
    private Integer id_academico;
    public String comentarios;

    // Creacion de un compromiso
    public CompromisoEntity(Integer id_academico, String nombre, String tipo_compromiso, String descripcion){
        this.descripcion = descripcion;
        this.id_academico = id_academico;
        this.nombre = nombre;
        this.tipo_compromiso = tipo_compromiso;
        this.puntuacion = 0;
        this.fecha_inicio = new Date();
    }
    public CompromisoEntity() {

    }
}
