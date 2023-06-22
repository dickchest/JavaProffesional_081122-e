package javaProfessionalCourse2.lesson32_Database.jdbc;

import java.sql.*;

public class H2MemoryDbDemo {
    public static void main(String[] args) throws SQLException {
        /*
        1) загрузить драйвер (зарегистрироваться в системе)
        2) подключится к базе данных - установить соединение
        3) создание нужной таблицы и/или вставка данных в таблицу
        4) извлечение данных
        5) закрытие ресурсов

        DriverManager - позволяет подключиться к базе данных по указанному URL
        Также он загружает JDBC Driver'a которые найдет в Classpath

        URL (Uniform Resource Locator) - это стандартный способ идентификации ресурсов.
        Состоит из:
        1) Протокол
        2) имя хоста
        3) путь

        Вариант №1 регистрации драйвера в системе:
        Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);

        Вариант №2:
        Class,.forName("com.mysql.jdbc.Driver")
         */

        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
        System.out.println(connection.isClosed());
        /*
        jdbc - протокол
        h2 - подтип протокола
        mem - (memory) имя хоста
        test - путь (название БД, к которой мы хотим подключтиься)
         */
        Statement statement = connection.createStatement();

        // создали таблицу
        String sqlRequest = "CREATE TABLE employees (id int primary key, name varchar(255))";

        System.out.println("Create table was success: " + statement.execute(sqlRequest)); // возрвщает булеан

        // вставить данные в таблицу
        String sqlRequest21 = "INSERT INTO employees VALUES (1, 'John')";
        String sqlRequest22 = "INSERT INTO employees VALUES (2, 'Bill')";

        int result = statement.executeUpdate(sqlRequest21);
        System.out.println("Insert first data was success: " + (result > 0));

        result = statement.executeUpdate(sqlRequest22);
        System.out.println("Insert first data was success: " + (result > 0));

        ResultSet resultSet = statement.executeQuery("select * from employees");
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " : " + resultSet.getString("name"));
        }

        statement.close();

        connection.close();

    }
}
