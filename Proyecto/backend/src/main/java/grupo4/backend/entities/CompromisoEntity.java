package grupo4.backend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

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
    private Integer puntuacion_academico1;
    private Integer puntuacion_academico2;
    private Integer puntuacion_academico3;
    private Integer puntuacion_total;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_inicio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha_termino;
    // id del creador del compromiso
    private Integer id_academico;
    public String comentarios;

    // archivo en arreglo de bytes
    @Lob
    private byte[] archivo;
    private String nombre_archivo;
    private String tipo_archivo;


    // Creacion de un compromiso
    public CompromisoEntity(Integer id_academico, String nombre, String tipo_compromiso, String descripcion){
        this.descripcion = descripcion;
        this.id_academico = id_academico;
        this.nombre = nombre;
        this.tipo_compromiso = tipo_compromiso;
        this.puntuacion_academico1 = 0;
        this.puntuacion_academico2 = 0;
        this.puntuacion_academico3 = 0;
        this.puntuacion_total = 0;
    }
    public CompromisoEntity() {
        this.puntuacion_academico1 = 0;
        this.puntuacion_academico2 = 0;
        this.puntuacion_academico3 = 0;
        this.puntuacion_total = 0;
    }
}
