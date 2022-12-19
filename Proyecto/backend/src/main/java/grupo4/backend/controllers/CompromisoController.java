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

    /*
     * Metodo : verCompromiso()
     * Descripcion : Retorna un compromiso
     * Parametros : Integer (id_compromiso)
     * Retorno : CompromisoEntity
     */
    @GetMapping("/compromiso/view/{id_compromiso}")
    public CompromisoEntity verCompromiso(@PathVariable Integer id_compromiso){
        return compromisoService.verCompromiso(id_compromiso);
    }

    /*
     * Metodo : editarCompromiso()
     * Descripcion : Edita un compromiso
     * Parametros : Integer (id_compromiso), CompromisoEntity (compromiso)
     * Retorno : CompromisoEntity
     */
    @PutMapping("/compromiso/editar/{id_compromiso}")
    public CompromisoEntity editarCompromiso(@PathVariable Integer id_compromiso, @RequestBody CompromisoEntity compromiso){
        return compromisoService.editarCompromiso(id_compromiso, compromiso);
    }

    /*
     * Metodo : viewAllC()
     * Descripcion : Retorna todos los compromisos de un usuario
     * Parametros : Integer (id_usuario)
     * Retorno : ArrayList<CompromisoEntity> 
     */
    @GetMapping("/compromiso/viewAll/{id_usuario}")
    public  ArrayList<CompromisoEntity> viewAllC(@PathVariable Integer id_usuario){
        return  compromisoService.verCompromisoS(id_usuario);
    }


    /*
     * Metodo : descargar()
     * Descripcion : Descarga un archivo
     * Parametros : Integer (id_compromiso)
     * Retorno : byte[]
     */
    @GetMapping("/compromiso/evidencia/download/{id_compromiso}")
    public byte[] descargar(@PathVariable Integer id_compromiso){
        return compromisoService.descargarArchivo(id_compromiso);
    }
}
