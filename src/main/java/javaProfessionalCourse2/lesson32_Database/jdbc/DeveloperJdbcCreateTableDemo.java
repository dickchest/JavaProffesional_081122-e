package javaProfessionalCourse2.lesson32_Database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeveloperJdbcCreateTableDemo {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javatest";

    static final String USER = "root";

    static final String PASSWORD = "dancer1977";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Statement statement = null;
        int result = 0;

        System.out.println("Registering JDBC driver ...");
        Class.forName(JDBC_DRIVER);

        System.out.println("Connection to DB ...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement ...");
        statement = connection.createStatement();

        System.out.println("Creating table ...");
        String sqlRequest = "CREATE TABLE developers(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), specialty VARCHAR(255), salary INT)";
        result = statement.executeUpdate(sqlRequest);
        System.out.println("Table created: " + result);

        System.out.println("Insert new DATA into database ...");
        sqlRequest = "insert into javatest.developers (name, specialty, salary) VALUES ('New1', 'new1', 5000)";
        statement.executeUpdate(sqlRequest);

        System.out.println("Closing connection and releasing resources ...");
        statement.close();
        connection.close();


    }
}
