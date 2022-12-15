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

    public CompromisoEntity asignarPuntaje(Integer id_compromiso, Integer puntaje) {
        Optional<CompromisoEntity> aux = compromisoRepository.findById(id_compromiso);
        CompromisoEntity compromiso = aux.get();
        compromiso.setPuntuacion(compromiso.getPuntuacion() + puntaje);
        return compromisoRepository.save(compromiso);
    }

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
