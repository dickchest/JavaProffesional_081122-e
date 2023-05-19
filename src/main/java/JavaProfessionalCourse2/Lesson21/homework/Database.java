package JavaProfessionalCourse2.Lesson21.homework;
/*
    Создайте класс Database, который имеет методы connect() и disconnect(),
    которые открывают и закрывают соединение с базой данных.
    Напишите тест, который проверяет, что методы connect() и disconnect()
    работают правильно.
 */
public class Database {
    private boolean connected;
    public void connect() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    public boolean isConnected() {
        return connected;
    }

    public void saveOrder(Object order) {

    }
}
