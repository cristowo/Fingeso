package grupo4.backend.repositories;

import grupo4.backend.entities.ComisionEvaluacionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ComisionEvaluacionRepository extends CrudRepository<ComisionEvaluacionEntity, Integer> {

    @Override
    ArrayList<ComisionEvaluacionEntity> findAll();

}
