package grupo4.backend.servicies;

import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.AcademicoRepository;
import grupo4.backend.repositories.CompromisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

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
    @PutMapping("{id_compromiso}")
    public CompromisoEntity editarCompromiso(Integer id_compromiso, CompromisoEntity compromiso2){
        Optional<CompromisoEntity> compromisoaux = compromisoRepository.findById(id_compromiso);
        CompromisoEntity compromiso = compromisoaux.get();
        if(compromiso2.getDescripcion() != null) {
            compromiso.setDescripcion(compromiso2.getDescripcion());
        }
        if(compromiso2.getTipo_compromiso() != null) {
            compromiso.setTipo_compromiso(compromiso2.getTipo_compromiso());
        }
        if(compromiso2.getNombre() != null) {
            compromiso.setNombre(compromiso2.getNombre());
        }
        if(compromiso2.getFecha_inicioSTR() != null){
            compromiso.setFecha_inicioSTR(compromiso2.getFecha_inicioSTR());
        }
        if(compromiso2.getFecha_terminoSTR() != null){
            compromiso.setFecha_terminoSTR(compromiso2.getFecha_terminoSTR());
        }
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
