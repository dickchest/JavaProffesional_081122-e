package javaProfessionalCourse2.lesson31.beans;

public class Dog {
    private String name = "Palkan";

    public Dog() {
        System.out.println("Dog constuctor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
