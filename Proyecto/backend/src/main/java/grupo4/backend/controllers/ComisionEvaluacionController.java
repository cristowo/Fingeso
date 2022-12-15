package grupo4.backend.controllers;

import grupo4.backend.entities.AcademicoEntity;
import grupo4.backend.repositories.AcademicoRepository;
import grupo4.backend.repositories.ComisionEvaluacionRepository;
import grupo4.backend.servicies.ComisionEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping
public class ComisionEvaluacionController {
    @Autowired
    ComisionEvaluacionService comisionEvaluacionService;

    @GetMapping("/comisionE/revisionAcademico/{idacademico}")
    public ArrayList<AcademicoEntity> getCompromisosAcademicos(@PathVariable Integer idacademico){
        return comisionEvaluacionService.academicosAevaluar(idacademico);
    }
}
