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


    public ArrayList<String> verCompromiso(Integer id_compromiso){
        Optional<CompromisoEntity> compromisoaux = compromisoRepository.findById(id_compromiso);
        CompromisoEntity compromiso = compromisoaux.get();
        ArrayList<String> array = new ArrayList<>();
        array.add(compromiso.getNombre());
        array.add(compromiso.getLink());
        array.add(compromiso.getDescripcion());
        array.add(compromiso.getFecha_inicio().toString());
        array.add(compromiso.getFecha_termino().toString());
        return array;
    }

    //ver todos los compromisos de un academico
    /*public ArrayList<CompromisoEntity> verAllCompromisos(Integer id_aca){
        return compromisoRepository.findCompromisoEntitiesById_academico(id_aca);
    }*/


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
