package grupo4.backend.repositories;

import grupo4.backend.entities.CompromisoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CompromisoRepository extends CrudRepository<CompromisoEntity, Integer> {
    //ArrayList<CompromisoEntity> findCompromisoEntitiesById_academico(Integer id_academico);

}
