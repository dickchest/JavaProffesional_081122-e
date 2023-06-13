package javaProfessionalCourse2.lesson28.homework.tasks1.exercise7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
7. Написать программу, моделирующую работу библиотеки. В библиотеке доступны к
чтению несколько книг. Некоторые из них можно выдавать на руки некоторые только
в читальный зал. Посетители могут брать одновременно по несколько книг на руки
и в читальный зал. Использовать можно все знания из Java, включая многопоточность.
 */
public class LibrarySimulator {
    public static void main(String[] args) {


        Library library = new Library();
        Customer customer1 = new Customer("thread 1", library);
        Customer customer2 = new Customer("thread 2", library);

        Thread thread1 = new Thread(customer1);
        Thread thread2 = new Thread(customer2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        customer1.printBorrowedBooks();
        customer2.printBorrowedBooks();

        // создаем 3х посетителей, которые хотят взять книги
        // 3 потока

        // взять книгу

        // вернуть книгу



    }
}
