package javaProfessionalCourse2.lesson32_Database.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperJdbcDemo {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javatest";

    static final String USER = "root";

    static final String PASSWORD = "dancer1977";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        List<Developer> database = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName(JDBC_DRIVER);

        System.out.println("Creating database connection ....");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement ...");
        statement = connection.createStatement();

        String sqlRequest = "select * from developers";

        ResultSet resultSet = statement.executeQuery(sqlRequest);

        System.out.println("Received data from database ...");


        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String speciality = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");
            System.out.println("=================");
            System.out.println("id: " + id);
            System.out.println("name: " + name);
            System.out.println("specialty: " + speciality);
            System.out.println("salary: " + salary);

            database.add(new Developer(id, name, speciality, salary));
        }

        System.out.println("Insert new DATA into database...");

        sqlRequest = "insert into javatest.developers (name, specialty, salary) VALUES ('New1', 'new1', 5000)";
        statement.executeUpdate(sqlRequest);
        sqlRequest = "insert into javatest.developers (name, specialty, salary) VALUES ('New2', 'new2', 6000)";
        statement.executeUpdate(sqlRequest);
        sqlRequest = "insert into javatest.developers (name, specialty, salary) VALUES ('New3', 'new3', 7000)";
        statement.executeUpdate(sqlRequest);

        System.out.println("Closing connection and releasing resources");
        resultSet.close();
        statement.close();
        connection.close();

        System.out.println("Our working database: ");

        for (Developer developer : database) {
            System.out.println(developer);
        }


    }
}
