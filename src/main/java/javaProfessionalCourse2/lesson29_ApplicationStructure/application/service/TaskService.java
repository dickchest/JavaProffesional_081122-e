package javaProfessionalCourse2.lesson29_ApplicationStructure.application.service;

import javaProfessionalCourse2.lesson29_ApplicationStructure.application.domain.Task;
import javaProfessionalCourse2.lesson29_ApplicationStructure.application.repository.TaskInMemoryRepository;

import java.util.Map;

public class TaskService {
    private TaskInMemoryRepository repository = new TaskInMemoryRepository();

    public Long saveTask(Task task) {
        repository.insert(task);
        return task.getId();
    }

    public Map<Long, Task> findAll(){
        return repository.findAll();
    }

    public Task findAById(Long id){
        return repository.findById(id);
    }
}
