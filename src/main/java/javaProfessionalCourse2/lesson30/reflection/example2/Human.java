package javaProfessionalCourse2.lesson30.reflection.example2;

public class Human {
    private String name;
    private String address;

    public Human(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    private int generateSecret(String code) {
        String str = "Secret".concat(code);
        System.out.println(str);
        return str.hashCode();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
