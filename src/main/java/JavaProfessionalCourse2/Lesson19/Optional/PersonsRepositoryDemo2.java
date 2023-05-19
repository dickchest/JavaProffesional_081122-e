package JavaProfessionalCourse2.Lesson19.Optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonsRepositoryDemo2 {
    public static void main(String[] args) {

        Map<Long, Person> ourDB = new HashMap<>();
        ourDB.put(1L, new Person("John", "12345"));
        ourDB.put(2L, new Person(null, null));

        PersonRepositoryVersion2 personRepositoryV2 = new PersonRepositoryVersion2(ourDB);

        personRepositoryV2.addPerson(1, new Person("John", "12345"));
        personRepositoryV2.addPerson(2, new Person(null, null));


        printPersonFromDatabase(1, personRepositoryV2);
        printPersonFromDatabase(2, personRepositoryV2);
        printPersonFromDatabase(3, personRepositoryV2);

    }

    public static void printPersonFromDatabase(long id, PersonRepositoryVersion2 personRepositoryVersion2) {
        Optional<Person> optPerson = personRepositoryVersion2.findById(id);
        if (optPerson.isPresent()) {
            Person person = optPerson.get();
            String personName = person.getName();
            if (personName != null) {
                System.out.println("length of name of person: " + personName.length());
            } else {
                System.out.println("please make validation database! Field is null ");
            }
        } else {
            System.out.println("user not found");
        }
    }
}
