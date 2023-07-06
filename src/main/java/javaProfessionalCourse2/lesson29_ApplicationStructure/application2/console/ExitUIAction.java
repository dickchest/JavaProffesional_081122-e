package javaProfessionalCourse2.lesson29_ApplicationStructure.application2.console;

public class ExitUIAction implements UIAction{
    @Override
    public void execute() {
        System.out.println("Bye-bye!");
        System.exit(0);
    }

    @Override
    public String getActionName() {
        return "Exit";
    }
}
