package javaProfessionalCourse2.lesson32_Database.jdbc;

import java.sql.SQLException;

public class H2MemoryDemo {
    public static void main(String[] args) throws SQLException {
        DatabaseManager manager = new DatabaseManager();
        manager.createTable();
        manager.getEmployee();
        manager.close();
    }
}
