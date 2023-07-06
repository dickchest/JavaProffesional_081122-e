package javaProfessionalCourse2.lesson29_ApplicationStructure.application.repository;

import javaProfessionalCourse2.lesson29_ApplicationStructure.application.domain.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskInMemoryRepository {
    private Long taskId = 0L;
    private Map<Long, Task> tasks = new HashMap<>();
    public Task insert(Task task) {
        task.setId(++taskId);
        tasks.put(taskId, task);
        return task;
    }

    public Map<Long, Task> findAll() {
        return tasks;
    }

    public Task findById(Long id) {
        return tasks.get(id);
    }
}
