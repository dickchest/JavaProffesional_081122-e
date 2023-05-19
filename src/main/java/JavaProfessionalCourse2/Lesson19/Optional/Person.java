package JavaProfessionalCourse2.Lesson19.Optional;

import java.util.Optional;

public class Person {
    private String name;

    private String login;
    int age;

    public Person(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public Optional<String> getOptionalName() {
        return Optional.ofNullable(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "name='" + name + '\'' +
                ", login='" + login +
                '}';
    }
}
