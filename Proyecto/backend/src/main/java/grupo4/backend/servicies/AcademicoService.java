package grupo4.backend.servicies;

import grupo4.backend.entities.AcademicoEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.entities.UsuarioEntity;
import grupo4.backend.repositories.AcademicoRepository;
import grupo4.backend.repositories.CompromisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class AcademicoService {
    @Autowired
    AcademicoRepository academicoRepository;
    @Autowired
    CompromisoRepository compromisoRepository;

    public ArrayList<AcademicoEntity> getall(){
        return academicoRepository.findAll();
    }

    public CompromisoEntity crearCompromiso(CompromisoEntity compromiso){
        return compromisoRepository.save(compromiso);
    }

    public CompromisoEntity registrarEvidencia(Integer id_compromiso, String evidencia){
        Optional<CompromisoEntity> compromisoaux = compromisoRepository.findById(id_compromiso);
        CompromisoEntity compromiso = compromisoaux.get();
        compromiso.setLink(evidencia);
        return compromisoRepository.save(compromiso);
    }

    public UsuarioEntity login(String correo, String pass) {
        Iterable<AcademicoEntity> all = academicoRepository.findAll();
        for (AcademicoEntity r : all) {
            if (correo.equals(r.getCorreo()) && pass.equals(r.getClave())) {
                    return r;
                }

            }
        return null;
    }

    public CompromisoEntity store(MultipartFile file, Integer id_compromiso) throws IOException {
        Optional<CompromisoEntity> antiguo = compromisoRepository.findById(id_compromiso);
        antiguo.get().setArchivo(file.getBytes());
        antiguo.get().setNombre_archivo(file.getOriginalFilename());
        antiguo.get().setTipo_archivo(file.getContentType());
        return compromisoRepository.save(antiguo.get());
    }

    public CompromisoEntity delete(Integer id_compromiso){
        Optional<CompromisoEntity> antiguo = compromisoRepository.findById(id_compromiso);
        antiguo.get().setArchivo(null);
        antiguo.get().setNombre_archivo(null);
        antiguo.get().setTipo_archivo(null);
        return compromisoRepository.save(antiguo.get());
    }

}
