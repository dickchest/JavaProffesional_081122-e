package javaProfessionalCourse2.lesson30_AnnotationReflection.reflection.example3;

public class MyClass {
    private int numbers;
    private String name = "default";

    public MyClass(int numbers, String name) {
        this.numbers = numbers;
        this.name = name;
    }


    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "numbers=" + numbers +
                ", name='" + name + '\'' +
                '}';
    }

    private void printData() {
        System.out.println(numbers + name);
    }
}
