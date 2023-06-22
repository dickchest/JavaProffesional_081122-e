package javaProfessionalCourse2.lesson32_Database.jdbc;

import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
        }
        return connection;
    }

    public void createTable() throws SQLException {
        int result = 0;
        Statement statement = getConnection().createStatement();
        result = statement.executeUpdate("CREATE TABLE employees (id INT PRIMARY KEY, name VARCHAR(255))");

        System.out.println("Create table: " + result);

        // вставить данные в таблицу

        result = statement.executeUpdate("INSERT INTO employees VALUES (1, 'John')");
        System.out.println("Insert data1: " + result);

        result = statement.executeUpdate("INSERT INTO employees VALUES (2, 'Bill')");
        System.out.println("Insert data2: " + result);
        statement.close();
    }

    public void getEmployee() throws SQLException {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id = " + id + ", name = " + name);
        }
        resultSet.close();
        statement.close();
    }

    public void close() throws SQLException{
        if (connection != null) {
            connection.close();
        }
    }


}
