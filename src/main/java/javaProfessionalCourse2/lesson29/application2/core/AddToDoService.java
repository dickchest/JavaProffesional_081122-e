package javaProfessionalCourse2.lesson29.application2.core;

import javaProfessionalCourse2.lesson29.application2.domain.ToDoEntity;
import javaProfessionalCourse2.lesson29.application2.dto.AddToDoRequest;
import javaProfessionalCourse2.lesson29.application2.dto.AddToDoResponse;
import javaProfessionalCourse2.lesson29.application2.repository.ToDoRepository;

public class AddToDoService {
    private ToDoRepository repository;

    public AddToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public AddToDoResponse add(AddToDoRequest request){
return null;
    }

}
