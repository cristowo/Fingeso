package grupo4.backend.Servicies;

import grupo4.backend.entities.AcademicosEntity;
import grupo4.backend.entities.ComisionEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.AcademicosRepository;
import grupo4.backend.repositories.CompromisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class CompromisoService {
    @Autowired
    CompromisoRepository compromisoRepository;
    @Autowired
    AcademicosRepository academicosRepository;

    //---------------------------------------------------------------------------------------------
    // Crear Compromiso
    public CompromisoEntity makeCompromiso(CompromisoEntity compromiso){
        return compromisoRepository.save(compromiso);
    }
    //---------------------------------------------------------------------------------------------
    // Actulizar Descripcion
    public CompromisoEntity actualizarCompromiso(Integer compromiso, String desc) {
        Optional<CompromisoEntity> aux = compromisoRepository.findById(compromiso);
        if(aux.isPresent()){
            CompromisoEntity ola = aux.get();
            ola.setDescripcion(desc);
            return compromisoRepository.save(ola);
        }
        return null;
    }
    //---------------------------------------------------------------------------------------------
    // Actulizar Evidencia (subio o eliminar)
    public CompromisoEntity actualizarEvidencia(Integer compromiso, String referencia) {
        Optional<CompromisoEntity> aux = compromisoRepository.findById(compromiso);
        if(aux.isPresent()){
            CompromisoEntity ola = aux.get();
            ola.setEvidencia(referencia);
            return compromisoRepository.save(ola);
        }
        return null;
    }
}


 /*
        Optional<CompromisoEntity> aux = compromisoRepository.findById(rut);
        if(aux.isPresent()){
            CompromisoEntity ola = aux.get();
            ola.setDescripcion(desc);
            compromisoRepository.save(ola);
        }
    }
  */