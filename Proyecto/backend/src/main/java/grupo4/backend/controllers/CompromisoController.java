package grupo4.backend.controllers;

import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.CompromisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompromisoController {
    @Autowired
    CompromisoRepository compromisoRepository;

    public CompromisoEntity actualizarCompromiso(Integer rut, String desc){
        Iterable<CompromisoEntity> all = compromisoRepository.findAll();
        for(CompromisoEntity registo: all){
            registo.setDescripcion(desc);
            return registo;
        }
        return null;
    }
}
