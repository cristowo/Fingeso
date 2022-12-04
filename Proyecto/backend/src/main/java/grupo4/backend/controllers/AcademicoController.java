package grupo4.backend.controllers;

import grupo4.backend.entities.AcademicoEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.servicies.AcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping
public class AcademicoController {
    @Autowired
    AcademicoService academicoService;

    @GetMapping("/academico/all")
    public ArrayList<AcademicoEntity> getall(){
        return academicoService.getall();
    }


    @GetMapping("/compromiso/crear/{id}")
    public CompromisoEntity crearCompromiso(@PathVariable Integer id, @RequestBody String nombre_compromiso, @RequestBody String descripcion, @RequestBody String tipo_compromiso){
        return academicoService.crearCompromiso(id, nombre_compromiso, descripcion, tipo_compromiso);
    }

    @GetMapping("/compromiso/evidencia/registrar/{id_compromiso}")
    public CompromisoEntity registrarEvidencia(@PathVariable Integer id_compromiso, @RequestBody String evidencia){
        return academicoService.registrarEvidencia(id_compromiso, evidencia);
    }

}
