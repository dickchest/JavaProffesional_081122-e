package javaProfessionalCourse2.lesson33_Hibernate.hibernateExample;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "worker") // можно указать имя БД
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name") // можно также указывать имя колонок
    private String name;

    @Column(name = "otdel")
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
