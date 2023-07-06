package javaProfessionalCourse2.lesson33_Hibernate.hibernateExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateExample {
    public static void main(String[] args) {
        // считывание настройки конфигурации Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // открываем фабрику сессий
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // создаем сотрудника
        Employee employee = new Employee("John", "IT");

        // сохранение сотрудника в БД
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();

        // чтение сотрудника из БД
        session = sessionFactory.openSession();
        Employee retrievedEmployee = session.get(Employee.class, 1);
        System.out.println("Retrieved employee: " + retrievedEmployee.getName() + " " + retrievedEmployee.getDepartment());
        session.close();

        //        // Обновление сотрудника
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//        retrievedEmployee.setDepartment("HR");
//        session.update(retrievedEmployee);
//        session.getTransaction().commit();
//        session.close();

        // Удаление сотрудника
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.delete(retrievedEmployee);
//        session.getTransaction().commit();
//        session.close();

        // Закрытие фабрики сессий Hibernate
        sessionFactory.close();

    }
}
