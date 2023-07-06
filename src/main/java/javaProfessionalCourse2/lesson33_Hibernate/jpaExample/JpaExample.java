package javaProfessionalCourse2.lesson33_Hibernate.jpaExample;

import jakarta.persistence.*;

import java.util.List;

public class JpaExample {
    public static void main(String[] args) {
        // создать фабрику EntityManager
        // фабрика - спец обект, в кот внутри мы укажем по каки правилам и как мы хотим, что б работала БД
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        EntityManager em = emf.createEntityManager();

        // создадим обект
        Person person = new Person();
        person.setName("Phil Collins");
        person.setAge(40);

        // сохранить обект в БД
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        // загрузка обьекта из БД
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class); // спец запрос на языке java persistance query lenguage
        List<Person> personList = query.getResultList();

        for (Person p : personList) {
            System.out.println("Loaded person: " + p);
        }

        em.close();
        emf.close();
    }
}
