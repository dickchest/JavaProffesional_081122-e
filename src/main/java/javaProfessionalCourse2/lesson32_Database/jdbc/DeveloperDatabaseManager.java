package javaProfessionalCourse2.lesson32_Database.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDatabaseManager {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javatest";
    static final String USER = "root";
    static final String PASSWORD = "root";


    Connection connection = null;

    // метод getConnection
    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    // create table
    public void createTable(String name) {
        int result;
        Statement statement;

        try {
            statement = getConnection().createStatement();
            String sqlRequest = "CREATE TABLE IF NOT EXISTS " + name + "(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), specialty VARCHAR(255), salary INT)";
            result = statement.executeUpdate(sqlRequest);
            System.out.println("table created: " + result);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // method getDevelopers
    public List<Developer> getDatabase(String nameOfTable) {
        List<Developer> database = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + nameOfTable);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("specialty");
                int salary = resultSet.getInt("salary");

                database.add(new Developer(id, name, specialty, salary));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return database;
    }

    // method addRecord
    public void addRecord(String nameOfTable, Developer developer) {
        try {
            Statement statement = getConnection().createStatement();
            int result = statement.executeUpdate("INSERT INTO " + nameOfTable + "(name, specialty, salary) VALUES('"
                    + developer.getName() + "', '" + developer.getSpeciality() + "', " + developer.getSalary() + ")");
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // method closeConnection
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
