package javaProfessionalCourse2.lesson30_AnnotationReflection.reflection.example5;

public class MyReflectionClassConstructor {
    private int number;
    private String name = "default";

    public MyReflectionClassConstructor(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setName(String name) {
        this.name = name;
    }
    private void printData(){
        System.out.println(number + name);
    }
}
