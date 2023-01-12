package pl.wsb.javaprojekt.dziennikocenbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.javaprojekt.dziennikocenbackend.model.Grade;

@Repository
public interface GradeRepository extends CrudRepository<Grade, Integer> {
}
