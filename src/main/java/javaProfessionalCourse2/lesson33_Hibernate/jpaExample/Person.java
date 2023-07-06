package javaProfessionalCourse2.lesson33_Hibernate.jpaExample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // этот класс должен быть напрямую свзяан с таблицей БД
public class Person {
    @Id // первичный ключ primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // стратегия автоинкримента
    /*
    стратегия sequence - используется для БД, кот используется такие посл как оракл
    тейбл - отдельные таблицы для генерации первичного ключа
     */
    private Integer id;

    private String name;
    private int age;



}
