package grupo4.backend.repositories;

import grupo4.backend.entities.AcademicoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AcademicoRepository extends CrudRepository<AcademicoEntity, Integer> {
    @Override
    ArrayList<AcademicoEntity> findAll();
}
