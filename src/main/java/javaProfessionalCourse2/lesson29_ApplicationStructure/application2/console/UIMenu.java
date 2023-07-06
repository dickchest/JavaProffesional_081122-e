package javaProfessionalCourse2.lesson29_ApplicationStructure.application2.console;

import java.util.List;
import java.util.Scanner;

public class UIMenu {
    private final List<UIAction> uiActions;

    public UIMenu(List<UIAction> uiActions) {
        this.uiActions = uiActions;
    }

    public void startUI() {
        try {
            System.out.println("Please enter your choice: ");
            for (int i = 0; i < uiActions.size(); i++) {
                var uiaction = uiActions.get(i);
                System.out.println(i + ". " + uiaction.getActionName());
            }
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            uiActions.get(userInput).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
