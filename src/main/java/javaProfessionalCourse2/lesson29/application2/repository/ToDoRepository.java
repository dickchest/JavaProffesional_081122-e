package javaProfessionalCourse2.lesson29.application2.repository;

import javaProfessionalCourse2.lesson29.application2.domain.ToDoEntity;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {
    ToDoEntity save(ToDoEntity entity);
    List<ToDoEntity> finaAll();

    Optional<ToDoEntity> findById(Integer id);
}
