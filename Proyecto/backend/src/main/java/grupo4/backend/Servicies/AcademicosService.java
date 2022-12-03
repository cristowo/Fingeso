package grupo4.backend.Servicies;

import grupo4.backend.entities.AcademicosEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.AcademicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class AcademicosService {
    @Autowired
    AcademicosRepository academicosRepository;

    public AcademicosEntity guardar(AcademicosEntity new_Academico){
        return academicosRepository.save(new_Academico);
    }

    public List<AcademicosEntity> getAll(){
        Iterable<AcademicosEntity> all = academicosRepository.findAll();
        List<AcademicosEntity> salida = new LinkedList<>();
        for(AcademicosEntity registro: all){
            salida.add(registro);
        }
        return salida;
    }

    public List<String> getallnames(){
        Iterable<AcademicosEntity> all = academicosRepository.findAll();
        List<String> salida = new ArrayList<>();
        for(AcademicosEntity r: all){
            salida.add("1");
        }
        return salida;
    }

    public CompromisoEntity makeCompromiso(Integer rut, String desc, String link){
        CompromisoEntity newCompromiso = new CompromisoEntity(rut, desc, link);
        return newCompromiso;
    }

    public Integer login(Integer rut, String contraseña){
        Iterable<AcademicosEntity> all = academicosRepository.findAll();
        for(AcademicosEntity r: all){
            if(rut == r.getId()){
                if(contraseña == r.getContraseña()){
                    return 1;
                }
                return 0;
            }
        }
        return 0;
    }
}
