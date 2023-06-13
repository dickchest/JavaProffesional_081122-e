package javaProfessionalCourse2.lesson28.volatileExample;

public class SharedData {
    private volatile boolean flag = false;

    public void setFlag() {
        flag = true; // изменяем значение флага
        System.out.println("Флаг установлен");
    }

    public void doSomething() {
        if (flag) {
            System.out.println("Что-то делает!");
        }
    }

}
