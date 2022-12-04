package grupo4.backend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

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
    private Integer id_academico;
    private String descripcion;
    private String evidencia;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date fecha;

    private Integer puntuacion;

    public CompromisoEntity(Integer id, Integer rut, String desc, String link){
        this.id_compromiso = id;
        this.id_academico = rut;
        this.descripcion = desc;
        this.evidencia = link;
        this.puntuacion = 0;
        //try {
            fecha = new Date();
            //this.fecha = new SimpleDateFormat("dd/mm/yyyy").parse("03/09/2000");

        //} catch (ParseException e) {
        //    throw new RuntimeException(e);
        //}
    }

    public CompromisoEntity() {

    }
}