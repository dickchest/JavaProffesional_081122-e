package JavaProfessionalCourse2.Lesson19.Optional;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonsRepositoryDemo3StreamType {
    public static void main(String[] args) {

        Map<Long, Person> ourDB = new HashMap<>();

        PersonRepositoryVersion2 personRepositoryV2 = new PersonRepositoryVersion2(ourDB);

        personRepositoryV2.addPerson(1, new Person("John", "12345"));
        personRepositoryV2.addPerson(2, new Person(null, null));


        printPersonFromDatabase(1, personRepositoryV2);
        printPersonFromDatabase(2, personRepositoryV2);
        printPersonFromDatabase(3, personRepositoryV2);

        Optional<Person> optionalPersonLogin =
                personRepositoryV2.findByLogin("12345");

        if (optionalPersonLogin.isPresent()) {
            Person person = optionalPersonLogin.get();
            System.out.println("Access granted!");
            System.out.println("user " + person.getName());
        } else {
            System.out.println("Accees denied");
        }

    }

    public static void printPersonFromDatabase(long id, PersonRepositoryVersion2 personRepositoryVersion2) {
        Optional<Person> optPerson = personRepositoryVersion2.findById(id);

        Optional<String> optionalPersonName = optPerson.map(user -> user.getName());

        optionalPersonName.ifPresent(personName -> System.out.println("длина имени " + personName.length()));

// строки 28 и 29 аналогичны строкам 34 - 37

        optPerson.map(person -> person.getName())
                .ifPresent(
                        personName -> System.out.println("длина имени " + personName.length())
                );

        // или еще короче форма записи
        personRepositoryVersion2.findById(id)
                .map(Person::getName)
                .ifPresent(
                        personName -> System.out.println("длина имени " + personName.length())
                );

    }
}
