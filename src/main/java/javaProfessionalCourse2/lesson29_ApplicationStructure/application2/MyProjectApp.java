package javaProfessionalCourse2.lesson29_ApplicationStructure.application2;

import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.console.*;
import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.core.AddToDoService;
import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.core.FindAllToDoService;
import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.repository.ArrayListToDoRepository;
import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.repository.ToDoRepository;

import java.util.ArrayList;
import java.util.List;

public class MyProjectApp {
    public static void main(String[] args) {
        ToDoRepository repository = new ArrayListToDoRepository();
        // дополнительный ОБЩИЙ СЕРВИС

        AddToDoService addToDoService = new AddToDoService(repository);
        FindAllToDoService findAllToDoService = new FindAllToDoService(repository);

        AddToDoUIAction addToDoUIAction = new AddToDoUIAction(addToDoService);
        FindToDoUIAction findToDoUIAction = new FindToDoUIAction(findAllToDoService);
        ExitUIAction exitUIAction = new ExitUIAction();

        List<UIAction> uiActions = new ArrayList<>();
        uiActions.add(addToDoUIAction);
        uiActions.add(findToDoUIAction);
        uiActions.add(exitUIAction);

        UIMenu uiMenu = new UIMenu(uiActions);

        uiMenu.startUI();
    }
}
