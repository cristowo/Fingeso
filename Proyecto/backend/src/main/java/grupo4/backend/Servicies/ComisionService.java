package grupo4.backend.Servicies;

import grupo4.backend.entities.AcademicosEntity;
import grupo4.backend.entities.ComisionEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.AcademicosRepository;
import grupo4.backend.repositories.ComisionRepository;
import grupo4.backend.repositories.CompromisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

@Service
public class ComisionService {
    @Autowired
    ComisionRepository comisionRepository;

    @Autowired
    AcademicosRepository academicosRepository;

    //formacion de la comision
    public ComisionEntity crearComision(String departamento){
        Iterable<AcademicosEntity> allDelDepartamento = academicosRepository.findAcademicosEntitiesByDepartamento(departamento);
        ArrayList<Integer> ruts = new ArrayList<>();
        Integer var;
        for(AcademicosEntity r: allDelDepartamento){
            ruts.add(r.getId());
        }
        Random random = new Random();
        // Se asume siempre que hayan los sufucientes academicos
        //Primero que pertenece
        var = random.nextInt(ruts.size());
        Integer rut1 = ruts.get(var);
        ruts.remove(var);
        //Segundo que pertenece
        var = random.nextInt(ruts.size());
        Integer rut2 = ruts.get(var);
        ruts.remove(var);
        //no pertenece
        Iterable<AcademicosEntity> all = academicosRepository.findAll();
        ruts.clear();
        for(AcademicosEntity r: all){
            if(r.getId() != rut1 && r.getId() != rut2){
                ruts.add(r.getId());
            }
        }
        var = random.nextInt(ruts.size());
        Integer rut3 = ruts.get(var);
        //--------------------------------------------------------------
        ComisionEntity aux = new ComisionEntity(rut1, rut2, rut3, departamento);
        return comisionRepository.save(aux);
    }
}
