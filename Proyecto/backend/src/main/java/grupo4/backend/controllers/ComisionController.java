package grupo4.backend.controllers;

import grupo4.backend.Servicies.ComisionService;
import grupo4.backend.entities.ComisionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ComisionController {
    @Autowired
    ComisionService comisionService;

    @PostMapping("/comision/create")
    public ComisionEntity nuevaComision(@RequestBody String departamento){
        return comisionService.crearComision(departamento);
    }
}
