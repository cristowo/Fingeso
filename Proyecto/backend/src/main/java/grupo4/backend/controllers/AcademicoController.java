package grupo4.backend.controllers;

import grupo4.backend.entities.AcademicoEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.entities.UsuarioEntity;
import grupo4.backend.servicies.AcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping
@CrossOrigin("*")
public class AcademicoController {
    @Autowired
    AcademicoService academicoService;
    /*
    * Metodo : getall()
    * Descripcion : Retorna todos los academicos registrados en la base de datos
    * Parametros : Ninguno
    * Retorno : ArrayList<AcademicoEntity>
    */
    @GetMapping("/academico/all")
    public ArrayList<AcademicoEntity> getall(){
        return academicoService.getall();
    }

    /*
     * Metodod : crearCompromiso()
     * Descripcion : Crea un nuevo compromiso en la base de datos
     * Parametros : CompromisoEntity
     * Retorno : CompromisoEntity
     */
    @PostMapping("/compromiso/crear")
    public CompromisoEntity crearCompromiso(@RequestBody CompromisoEntity compromiso){
        return academicoService.crearCompromiso(compromiso);
    }

    /*
     * Metodo: registrarEvidencia()
     * Descripcion : Registra la evidencia de un compromiso
     * Parametros : Integer, String
     * Retorno : CompromisoEntity
     */
    @PostMapping("/compromiso/evidencia/registrar/{id_compromiso}")
    public CompromisoEntity registrarEvidencia(@PathVariable Integer id_compromiso, @RequestBody String evidencia){
        return academicoService.registrarEvidencia(id_compromiso, evidencia);
    }

    /*
     * Metodo : login()
     * Descripcion : Inicia sesion en la aplicacion
     * Parametros : AcademicoEntity
     * Retorno : UsuarioEntity
     */
    @PostMapping("/academicos/login")
    public UsuarioEntity login(@RequestBody AcademicoEntity nuevo){
        return academicoService.login(nuevo.getCorreo(), nuevo.getClave());
    }

    /*
     * Metodo : uploadFile()
     * Descripcion : Sube un archivo a la base de datos
     * Parametros : MultipartFile, Integer
     * Retorno : CompromisoEntity
     */
    @PostMapping("/compromiso/evidencia/subir/{id_compromiso}")
    public CompromisoEntity uploadFile(@RequestParam(value = "file") MultipartFile file, @PathVariable Integer id_compromiso) throws IOException {
        return academicoService.store(file, id_compromiso);
    }

    /*
     * Metodo : deleteFile()
     * Descripcion : Elimina un archivo de la base de datos
     * Parametros : Integer (id_compromiso)
     * Retorno : CompromisoEntity
     */
    @PostMapping("/compromiso/evidencia/eliminar/{id_compromiso}")
    public CompromisoEntity deleteFile(@PathVariable Integer id_compromiso){
        return academicoService.delete(id_compromiso);
    }
}
