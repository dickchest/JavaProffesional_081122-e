package javaProfessionalCourse2.lesson29.application2.core;

import javaProfessionalCourse2.lesson29.application2.console.FindToDoUIAction;
import javaProfessionalCourse2.lesson29.application2.core.validation.CoreError;
import javaProfessionalCourse2.lesson29.application2.domain.ToDoEntity;
import javaProfessionalCourse2.lesson29.application2.dto.FindAllToDoResponse;
import javaProfessionalCourse2.lesson29.application2.dto.ToDoDTO;
import javaProfessionalCourse2.lesson29.application2.repository.ToDoRepository;

import java.util.ArrayList;
import java.util.List;

public class FindAllToDoService {
    private ToDoRepository repository;

    public FindAllToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public FindAllToDoResponse findAll() {

        List<ToDoEntity> entities = repository.finaAll();
        List<ToDoDTO> dtos = new ArrayList<>();
        List<CoreError> errors = new ArrayList<>();

        if (entities == null || entities.isEmpty()) {
            errors.add(new CoreError("ToDo database is null"));
        } else {
            for (int i = 0; i < entities.size(); i++) {
                dtos.add(convert(entities.get(i)));
            }
        }

        return new FindAllToDoResponse(dtos, errors);
    }

    private ToDoDTO convert(ToDoEntity entity) {
        return new ToDoDTO(entity.getName(), entity.getDescription());
    }
}
