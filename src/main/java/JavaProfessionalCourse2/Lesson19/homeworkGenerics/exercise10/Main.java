package JavaProfessionalCourse2.Lesson19.homeworkGenerics.exercise10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ivan" , 10));
        persons.add(new Person("Vasya" , 12));
        persons.add(new Person("Oleg" , 9));

        SortUtils.sortByProperty(persons, "age");
        System.out.println(persons);

        SortUtils.sortByProperty(persons, "name");
        System.out.println(persons);
    }
}
