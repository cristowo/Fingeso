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

@Entity
@Table(name = "compromisos")
@Data
public class CompromisoEntity {
    @Id

    private Integer rut_academico;
    private String descripcion;
    private String evidencia;
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date fecha;

    public CompromisoEntity(Integer rut, String desc, String link){
        this.rut_academico = rut;
        this.descripcion = desc;
        this.evidencia = link;
        try {
            this.fecha = new SimpleDateFormat("dd/mm/yyyy").parse("03/09/2000");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public CompromisoEntity() {

    }
}
