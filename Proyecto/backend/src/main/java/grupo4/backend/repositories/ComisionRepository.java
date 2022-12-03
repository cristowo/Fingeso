package grupo4.backend.repositories;

import grupo4.backend.entities.ComisionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComisionRepository extends CrudRepository<ComisionEntity, Integer> {
    @Override
    Iterable<ComisionEntity> findAll();

}
