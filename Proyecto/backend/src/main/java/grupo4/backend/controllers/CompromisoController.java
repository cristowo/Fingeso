package grupo4.backend.controllers;

import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.servicies.CompromisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping
@CrossOrigin("*")
public class CompromisoController {
    @Autowired
    CompromisoService compromisoService;

    @GetMapping("/compromiso/view/{id_compromiso}")
    public CompromisoEntity verCompromiso(@PathVariable Integer id_compromiso){
        return compromisoService.verCompromiso(id_compromiso);
    }
    @PutMapping("/compromiso/editar/{id_compromiso}")
    public CompromisoEntity editarCompromiso(@PathVariable Integer id_compromiso, @RequestBody CompromisoEntity compromiso){
        return compromisoService.editarCompromiso(id_compromiso, compromiso);
    }

    @GetMapping("/compromiso/viewAll/{id_usuario}")
    public  ArrayList<CompromisoEntity> viewAllC(@PathVariable Integer id_usuario){
        return  compromisoService.verCompromisoS(id_usuario);
    }
}
