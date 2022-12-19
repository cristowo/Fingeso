package grupo4.backend.servicies;

import grupo4.backend.entities.AcademicoEntity;
import grupo4.backend.entities.ComisionEvaluacionEntity;
import grupo4.backend.entities.CompromisoEntity;
import grupo4.backend.repositories.AcademicoRepository;
import grupo4.backend.repositories.ComisionEvaluacionRepository;
import grupo4.backend.repositories.CompromisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class ComisionEvaluacionService {
    @Autowired
    ComisionEvaluacionRepository comisionEvaluacionRepository;

    @Autowired
    CompromisoRepository compromisoRepository;

    @Autowired
    AcademicoRepository academicoRepository;

    /*
     * metodo: asignarPuntaje()
     * descripcion: asigna un puntaje a un compromiso
     * parametros: Integer (id_evaluador), Integer (id_compromiso), Integer (puntaje)
     * retorno: CompromisoEntity
     */
    public CompromisoEntity asignarPuntaje(Integer id_evaluador, Integer id_compromiso, Integer puntaje) {
        // encontrar compromiso
        Optional<CompromisoEntity> aux = compromisoRepository.findById(id_compromiso);
        CompromisoEntity compromiso = aux.get();
        // encontrar comision
        // primero hay que encontrar al academico que es
        Optional<AcademicoEntity> auxAcademico = academicoRepository.findById(compromiso.getId_academico());
        AcademicoEntity academico = auxAcademico.get();
        // encontramos la comision
        Optional<ComisionEvaluacionEntity> auxComision = comisionEvaluacionRepository.findById(academico.getComision_evaluadora());
        if(auxComision.get().getId_academico_1() == id_evaluador){
            compromiso.setPuntuacion_academico1(puntaje);
        }else if(auxComision.get().getId_academico_2() == id_evaluador){
            compromiso.setPuntuacion_academico2(puntaje);
        }else if(auxComision.get().getId_academico_3() == id_evaluador){
            compromiso.setPuntuacion_academico3(puntaje);
        }

        compromiso.setPuntuacion_total((compromiso.getPuntuacion_academico1() + compromiso.getPuntuacion_academico2() + compromiso.getPuntuacion_academico3())/3);
        return compromisoRepository.save(compromiso);
    }


    /*
     * Metodo : acdemicoAevaluar()
     * Descripcion: devuelve los academicos que tiene que evaluar un academico
     * Parametros: Integer (id_academico)
     * Retorno: ArrayList<AcademicoEntity>
     */
    public ArrayList<AcademicoEntity> academicosAevaluar(Integer idacademico){
        ArrayList<ComisionEvaluacionEntity> comisiones = comisionEvaluacionRepository.findAll();
        ArrayList<AcademicoEntity> academicos = new ArrayList<>();
        ArrayList<AcademicoEntity> academicoaux;
        for(int i = 0; i < comisiones.size(); i++){
            if(idacademico == comisiones.get(i).getId_academico_1()
            ||idacademico == comisiones.get(i).getId_academico_2()
            ||idacademico == comisiones.get(i).getId_academico_3()){
                academicoaux = academicoRepository.findAll();
                for(int j = 0; j < academicoaux.size(); j++){
                    if(academicoaux.get(j).getComision_evaluadora() == comisiones.get(i).getId_comision()) {
                        academicos.add(academicoaux.get(j));
                    }
                }
            }
        }
        return academicos;
    }
}
