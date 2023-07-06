package javaProfessionalCourse2.lesson29_ApplicationStructure.application2.console;

import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.core.FindAllToDoService;

public class FindToDoUIAction implements UIAction{

    private final FindAllToDoService findAllToDoService;

    public FindToDoUIAction(FindAllToDoService findAllToDoService) {
        this.findAllToDoService = findAllToDoService;
    }

    @Override
    public void execute() {
        var response = findAllToDoService.findAll();
        System.out.println(response);
    }

    @Override
    public String getActionName() {
        return "Find All ToDo";
    }
}
