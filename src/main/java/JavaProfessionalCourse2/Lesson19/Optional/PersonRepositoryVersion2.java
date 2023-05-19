package JavaProfessionalCourse2.Lesson19.Optional;

import java.util.Map;
import java.util.Optional;

public class PersonRepositoryVersion2 {
    private final Map<Long, Person> persons;

    public PersonRepositoryVersion2(Map<Long, Person> persons) {
        this.persons = persons;
    }

    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(persons.get(id));
    }
    public void addPerson(long id, Person person) {
        persons.put(id, person);
    }

    public Optional<Person> findByLogin(String login) {
        for (Person tempPerson : persons.values()) {
            if (tempPerson.getLogin().equals(login)) {
                return Optional.of(tempPerson);
            }
        }
        return Optional.empty();
    }
}
