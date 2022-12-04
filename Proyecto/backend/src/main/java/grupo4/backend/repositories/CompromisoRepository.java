package grupo4.backend.repositories;

import grupo4.backend.entities.AcademicosEntity;
import grupo4.backend.entities.ComisionEntity;
import grupo4.backend.entities.CompromisoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompromisoRepository extends CrudRepository<CompromisoEntity, Integer> {
    @Override
    Iterable<CompromisoEntity> findAll();

}
