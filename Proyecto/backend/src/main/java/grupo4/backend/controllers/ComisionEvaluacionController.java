package grupo4.backend.controllers;

import grupo4.backend.entities.AcademicoEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.AcademicoRepository;
import grupo4.backend.repositories.ComisionEvaluacionRepository;
import grupo4.backend.servicies.ComisionEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ComisionEvaluacionController {
    @Autowired
    ComisionEvaluacionService comisionEvaluacionService;

    /*
     * Metodo : getCompromisosAcademicos()
     * Descripcion : Retorna todos los compromisos de un academico
     * Parametros : Integer (id_academico)
     * Retorno : ArrayList<AcademicoEntity>
     */
    @GetMapping("/comisionE/revisionAcademico/{idacademico}")
    public ArrayList<AcademicoEntity> getCompromisosAcademicos(@PathVariable Integer idacademico){
        return comisionEvaluacionService.academicosAevaluar(idacademico);
    }

    /*
     * Metodo : getCompromisosAcademicos()
     * Descripcion : Retorna todos los compromisos de un academico
     * Parametros : Integer (id_academico)
     * Retorno : ArrayList<AcademicoEntity>
     */
    @PutMapping("/evaluar/{id_evaluador}/{id_compromiso}/{puntaje}")
    public CompromisoEntity asignarPuntaje(@PathVariable Integer id_evaluador, @PathVariable Integer id_compromiso, @PathVariable Integer puntaje){
        return comisionEvaluacionService.asignarPuntaje(id_evaluador, id_compromiso, puntaje);
    }
}
