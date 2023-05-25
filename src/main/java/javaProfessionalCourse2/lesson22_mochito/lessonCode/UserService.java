package javaProfessionalCourse2.lesson22_mochito.lessonCode;

public class UserService {
    // 1 создать эекземпляр класса PersonDB прямо тут

    PersonDB personDB = new PersonDB();
    // 2 получить его из вне в качестве параметра конструктора

    /*
    это сервис, он не должен сдесь создавать БД, а только обрабатывать
     */

    public UserService(PersonDB personDB) {
        this.personDB = personDB;
    }

    public void printAllPersons() {}

    public void addPerson(Person newPerson) {}

    public PersonDB getAllPersons() {
        return personDB;
    }
}
