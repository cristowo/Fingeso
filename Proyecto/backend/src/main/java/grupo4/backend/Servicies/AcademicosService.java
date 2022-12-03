package grupo4.backend.Servicies;

import grupo4.backend.entities.AcademicosEntity;
import grupo4.backend.entities.ComisionEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.AcademicosRepository;
import grupo4.backend.repositories.ComisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AcademicosService {
    @Autowired
    AcademicosRepository academicosRepository;

    @Autowired
    ComisionRepository comisionRepository;

    @Autowired
    ComisionService comisionService;


    /*public AcademicosEntity guardar(AcademicosEntity new_Academico){
        return academicosRepository.save(new_Academico);
    }*/

    public List<AcademicosEntity> getAll(){
        Iterable<AcademicosEntity> all = academicosRepository.findAll();
        List<AcademicosEntity> salida = new LinkedList<>();
        for(AcademicosEntity registro: all){
            salida.add(registro);
        }
        return salida;
    }

    /*public List<String> getallnames(){
        Iterable<AcademicosEntity> all = academicosRepository.findAll();
        List<String> salida = new ArrayList<>();
        for(AcademicosEntity r: all){
            salida.add(r.getName());
        }
        return salida;
    }*/

    public String getNameByRut(Integer rut){
        Iterable<AcademicosEntity> all = academicosRepository.findAll();
        for(AcademicosEntity r: all){
            if(rut == r.getId()) {
                return r.getName();
            }
        }
        return "404, not found";
    }
    //OJO PORKE NO ESTA ASIGNANDO LA COMISION!!!
    public AcademicosEntity asignarComision(Integer rut){
        Iterable<ComisionEntity> aux = comisionRepository.findAll();
        Optional<AcademicosEntity> nuevoacademico = academicosRepository.findById(rut);
        AcademicosEntity academico = nuevoacademico.get();
        ArrayList<Integer> arrayComision = new ArrayList<>();
        for(ComisionEntity r: aux){
            if(r.getDepartamento() == academico.getDepartamento()){
                arrayComision.add(r.getId_comision());
            }
        }
        if(arrayComision.size() == 0){
            comisionService.crearComision(academico.getDepartamento());
        }else{
            Random random = new Random();
            Integer var = random.nextInt(arrayComision.size());
            academico.setId_comision_evaluadora(arrayComision.get(var));
        }
        return academicosRepository.save(academico);
    }




    /*public Integer login(Integer rut, String contraseña){
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
    }*/
    //-----------------------------------------------------------------------------------------
}
