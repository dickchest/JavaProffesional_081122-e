package javaProfessionalCourse2.lesson29_ApplicationStructure.application.console;

import javaProfessionalCourse2.lesson29_ApplicationStructure.application.domain.Task;
import javaProfessionalCourse2.lesson29_ApplicationStructure.application.service.TaskService;

import java.util.Scanner;

public class ConsoleUI {

    private TaskService service = new TaskService();

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("1. Create task");
                System.out.println("2. Find all tasks");
                System.out.println("3. Find task by id");
                System.out.println("4. Exit");

                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        long newId = createTask();
                        System.out.println("Create success! New record id: " + newId);
                        break;

                    case 2:
                        System.out.println(service.findAll());
                        break;

                    case 3:
                        Task findTask = findTask();
                        if (findTask != null) {
                            System.out.println("Find record: " + findTask);
                        } else {
                            System.out.println("Record not found");
                        }
                        break;

                    case 4:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Long createTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();

        System.out.println("Enter task description: ");
        String description = scanner.nextLine();

        Task newTask = new Task();
        newTask.setName(name);
        newTask.setDescription(description);

        return service.saveTask(newTask);

    }

    private Task findTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task id: ");
        Long id = scanner.nextLong();

        return service.findAById(id);
    }
}
