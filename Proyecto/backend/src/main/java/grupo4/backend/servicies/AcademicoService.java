package grupo4.backend.servicies;

import grupo4.backend.entities.AcademicoEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.AcademicoRepository;
import grupo4.backend.repositories.CompromisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public CompromisoEntity crearCompromiso(Integer id_user, String nombre_compromiso, String descripcion, String tipo_compromiso){
        CompromisoEntity compromiso = new CompromisoEntity(id_user, nombre_compromiso, tipo_compromiso, descripcion);
        return compromisoRepository.save(compromiso);
    }

    public CompromisoEntity registrarEvidencia(Integer id_compromiso, String evidencia){
        Optional<CompromisoEntity> compromisoaux = compromisoRepository.findById(id_compromiso);
        CompromisoEntity compromiso = compromisoaux.get();
        compromiso.setLink(evidencia);
        return compromisoRepository.save(compromiso);
    }
}
