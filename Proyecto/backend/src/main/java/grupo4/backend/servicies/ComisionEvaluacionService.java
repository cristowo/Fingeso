package grupo4.backend.servicies;

import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.ComisionEvaluacionRepository;
import grupo4.backend.repositories.CompromisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class ComisionEvaluacionService {
    @Autowired
    ComisionEvaluacionRepository comisionEvaluacionRepository;

    @Autowired
    CompromisoRepository compromisoRepository;

    public CompromisoEntity asignarPuntaje(Integer id_compromiso, Integer puntaje){
        Optional<CompromisoEntity> aux = compromisoRepository.findById(id_compromiso);
        CompromisoEntity compromiso = aux.get();
        compromiso.setPuntuacion(compromiso.getPuntuacion() + puntaje);
        return compromisoRepository.save(compromiso);
    }
}
