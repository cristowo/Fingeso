package grupo4.backend.controllers;

import grupo4.backend.Servicies.CompromisoService;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.CompromisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CompromisoController {
    @Autowired
    CompromisoService compromisoService;
    @PostMapping("/compromisos/actualizar/desc/{compromiso}")
    public CompromisoEntity actualizarCompromiso(@PathVariable Integer compromiso, @RequestBody String desc){
        return compromisoService.actualizarCompromiso(compromiso, desc);
    }

    @PostMapping("/compromisos/actualizar/evidencia/{compromiso}")
    public CompromisoEntity actualizarEvidencia(@PathVariable Integer compromiso, @RequestBody String evidencia){
        return compromisoService.actualizarEvidencia(compromiso, evidencia);
    }

    @PostMapping("/compromiso/{rut}")
    public CompromisoEntity crearCompromiso(@RequestBody CompromisoEntity compromiso){
        return compromisoService.makeCompromiso(compromiso);
    }


}
