package JavaProfessionalCourse2.Lesson21.homework;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database database = new Database();

    @Before
    void method1() {

        System.out.println("База данных создана");
    }


    @Test
        //    проверяем, если соединение с самого начала
    void isConnectedBeginning() {
        assertFalse(database.isConnected());
    }

    @Test
        // Подключаемся к базе данных
        // Проверяем, что соединение установлено
    void connect() {
        database.connect();
        assertTrue(database.isConnected());
    }

    @Test
        // Отключаемся от базы данных
        // Проверяем, что соединение закрыто
    void disconnect() {
        database.disconnect();
        assertFalse(database.isConnected());
    }

    @Test
    void isConnected() {
    }
}