package grupo4.backend.repositories;

import grupo4.backend.entities.AcademicosEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcademicosRepository extends CrudRepository<AcademicosEntity, Integer> {
    @Override
    Iterable<AcademicosEntity> findAll();

    Iterable<AcademicosEntity> findAcademicosEntitiesByDepartamento(String departamento);

    Optional<AcademicosEntity> findById(Integer rut);

}


