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

    @GetMapping("/academicos/name/{rut}/")
    public String getnamebyrut(@PathVariable Integer rut){
        return academicosService.getNameByRut(rut);
    }

    @PostMapping("/academicos/asignarcomision/{rut}")
    public AcademicosEntity asignarComision(@PathVariable Integer rut){
        return academicosService.asignarComision(rut);
    }
}
