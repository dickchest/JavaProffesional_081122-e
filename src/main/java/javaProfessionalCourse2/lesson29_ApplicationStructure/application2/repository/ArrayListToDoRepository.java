package javaProfessionalCourse2.lesson29_ApplicationStructure.application2.repository;

import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.domain.ToDoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayListToDoRepository implements ToDoRepository {

    private Integer idSequence = 1;
    private List<ToDoEntity> database = new ArrayList<>();

    @Override
    public ToDoEntity save(ToDoEntity entity) {
        if (entity.getId() != null) {
            return update(entity);
        } else {
            entity.setId(idSequence);
            idSequence++;
            database.add(entity);

        }
        return entity;
    }

    private ToDoEntity update(ToDoEntity entity) {
        for (int i = 0; i < database.size(); i++) {
            var existingEntity = database.get(i);
            if (existingEntity.getId() == entity.getId()) {
                database.set(i, entity);
                return entity;
            }
        }
        throw new IllegalStateException("Failed to update");
    }

    @Override
    public List<ToDoEntity> finaAll() {
        return database;
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        return database.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }
}
