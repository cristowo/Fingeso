package grupo4.backend.servicies;

import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.CompromisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class CompromisoService {
    @Autowired
    CompromisoRepository compromisoRepository;

    public CompromisoEntity verCompromiso(Integer id_compromiso){
        Optional<CompromisoEntity> compromisoaux = compromisoRepository.findById(id_compromiso);
        CompromisoEntity compromiso = compromisoaux.get();
        return compromiso;
    }

    public CompromisoEntity editarCompromiso(Integer id_compromiso, String nombre_compromiso, String descripcion, String tipo_compromiso){
        Optional<CompromisoEntity> compromisoaux = compromisoRepository.findById(id_compromiso);
        CompromisoEntity compromiso = compromisoaux.get();
        compromiso.setDescripcion(descripcion);
        compromiso.setTipo_compromiso(tipo_compromiso);
        compromiso.setNombre(nombre_compromiso);
        return compromisoRepository.save(compromiso);
    }


    public  ArrayList<CompromisoEntity> verCompromisoS(Integer id_academico) {
        Iterable<CompromisoEntity> allcompromisos = compromisoRepository.findAll();
        ArrayList<CompromisoEntity> outlist = new ArrayList<>();
        for(CompromisoEntity r : allcompromisos){
            if(id_academico == r.getId_academico()) {
                outlist.add(r);
            }
        }
        return  outlist;
    }



}
