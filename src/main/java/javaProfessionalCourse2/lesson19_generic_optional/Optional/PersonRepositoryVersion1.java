package javaProfessionalCourse2.lesson19_generic_optional.Optional;

import java.util.Map;

public class PersonRepositoryVersion1 {
    private final Map<Long, Person> persons;

    public PersonRepositoryVersion1(Map<Long, Person> persons) {
        this.persons = persons;
    }

    public Person findById(Long id) {
        return persons.get(id);
    }
    public void addPerson(long id, Person person) {
        persons.put(id, person);
    }
}
