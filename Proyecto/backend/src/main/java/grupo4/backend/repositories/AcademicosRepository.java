package grupo4.backend.repositories;

import grupo4.backend.entities.AcademicosEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface AcademicosRepository extends CrudRepository<AcademicosEntity, Integer> {
    @Override
    Iterable<AcademicosEntity> findAll();

    //AcademicosEntity save(AcademicosEntity academicosEntity);
}


