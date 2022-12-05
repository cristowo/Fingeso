package grupo4.backend.controllers;

import grupo4.backend.entities.AcademicoEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.entities.UsuarioEntity;
import grupo4.backend.servicies.AcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping
@CrossOrigin("*")
public class AcademicoController {
    @Autowired
    AcademicoService academicoService;

    @GetMapping("/academico/all")
    public ArrayList<AcademicoEntity> getall(){
        return academicoService.getall();
    }


    @PostMapping("/compromiso/crear")
    public CompromisoEntity crearCompromiso(@RequestBody CompromisoEntity compromiso){
        return academicoService.crearCompromiso(compromiso);
    }

    @PostMapping("/compromiso/evidencia/registrar/{id_compromiso}")
    public CompromisoEntity registrarEvidencia(@PathVariable Integer id_compromiso, @RequestBody String evidencia){
        return academicoService.registrarEvidencia(id_compromiso, evidencia);
    }

    @PostMapping("/academicos/login")
    public UsuarioEntity login(@RequestBody AcademicoEntity nuevo){
        return academicoService.login(nuevo.getCorreo(), nuevo.getClave());
    }

}
