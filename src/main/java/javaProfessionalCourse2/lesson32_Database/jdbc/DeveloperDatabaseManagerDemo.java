package javaProfessionalCourse2.lesson32_Database.jdbc;

import java.util.ArrayList;
import java.util.List;

public class DeveloperDatabaseManagerDemo {
    public static void main(String[] args) {
        DeveloperDatabaseManager dbManager = new DeveloperDatabaseManager();
        List<Developer> database = new ArrayList<>();
        database = dbManager.getDatabase("developers");
        System.out.println(database);

        dbManager.addRecord("developers" , new Developer(1,"John", "it", 2500));
        database = dbManager.getDatabase("developers");
        System.out.println(database);

        dbManager.createTable("employees");
        dbManager.addRecord( "employees", new Developer(2,"Bill", "housekeeper", 1500));
        database = dbManager.getDatabase("employees");
        System.out.println(database);

        dbManager.close();
    }
}
