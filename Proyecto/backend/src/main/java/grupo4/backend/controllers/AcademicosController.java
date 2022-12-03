package grupo4.backend.controllers;

import grupo4.backend.Servicies.AcademicosService;
import grupo4.backend.entities.AcademicosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AcademicosController {
    @Autowired
    AcademicosService academicosService;

    @GetMapping("/academicos/getAll/")
    public List<AcademicosEntity> getAll(){
        return academicosService.getAll();
    }

    @PostMapping("/academicos/create")
    public AcademicosEntity crear(@RequestBody AcademicosEntity new_Academico){
        AcademicosEntity obj = academicosService.guardar(new_Academico);
        return obj;
    }

    @GetMapping("/academicos/prueba/")
    public List<String> getTodos(){
        return List.of("Gaspar", "weon");
    }

    @GetMapping("/academicos/names/")
    public List<String> getallnames(){
        return academicosService.getallnames();
    }
}
